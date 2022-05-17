package com.example.auctionseller.controller;

import com.example.auctionseller.config.AppProperty;
import com.example.auctionseller.model.CustomMessage;
import com.example.auctionseller.messagemq.MQConfig;
import com.example.auctionseller.uploader.service.StorageService;
import com.example.auctionseller.util.MessageUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;

@RestController
public class SellerController {

    private static final String UPLOAD_DIR = "/upload/";

    private final  RabbitTemplate template;
    private final StorageService storageService;
    private final AppProperty appProperty;

    public SellerController(RabbitTemplate template, StorageService storageService, AppProperty appProperty) {
        this.template = template;
        this.storageService = storageService;
        this.appProperty = appProperty;
        this.appProperty.init();
    }

    @PostMapping(value = "/sell")
    public String sellItem(@RequestBody CustomMessage message){
        message.setMessageDate(new Date());
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);

        return "Message Published";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        final String absoluteUploadDir = System.getProperty("user.dir") + Path.of(AppProperty.UPLOAD_DIR);
        byte[] fileByte = storageService.store(file, Paths.get(absoluteUploadDir));
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, MessageUtil.makeCustomMessage(fileByte));
        return "uploaded "+file.getOriginalFilename();
    }
}
