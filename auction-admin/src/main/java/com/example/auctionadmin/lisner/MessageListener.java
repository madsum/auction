package com.example.auctionadmin.lisner;

import com.example.auctionadmin.messagemq.MQBuyerConfig;
import com.example.auctionadmin.model.CustomMessage;
import com.example.auctionadmin.repsitory.AuctionAdminRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    private final AuctionAdminRepository repository;
   @Autowired
    private RabbitTemplate template;

    public MessageListener(AuctionAdminRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = "seller_queue")
    public void listener(CustomMessage message) {
        System.out.println(message);
        repository.save(message);
        template.convertAndSend(MQBuyerConfig.EXCHANGE,
                MQBuyerConfig.ROUTING_KEY, message);
    }

}
