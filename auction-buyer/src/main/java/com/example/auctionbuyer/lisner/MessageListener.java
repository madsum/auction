package com.example.auctionbuyer.lisner;

import com.example.auctionbuyer.model.CustomMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {


    @RabbitListener(queues = "buyer_queue")
    public void listener(CustomMessage message) {
        System.out.println(message);
    }

}
