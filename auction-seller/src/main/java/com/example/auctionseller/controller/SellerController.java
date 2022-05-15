package com.example.auctionseller.controller;

import com.example.auctionseller.model.CustomMessage;
import com.example.auctionseller.messagemq.MQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class SellerController {

    private final  RabbitTemplate template;

    public SellerController(RabbitTemplate template) {
        this.template = template;
    }

    @PostMapping(value = "/sell")
    public String sellItem(@RequestBody CustomMessage message){
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);

        return "Message Published";
    }
}
