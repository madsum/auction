package com.example.auctionadmin.messagemq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQBuyerConfig {

    public static final String QUEUE = "buyer_queue";
    public static final String EXCHANGE = "buyer_exchange";
    public static final String ROUTING_KEY = "buyer_routingKey";

    @Bean(name = "buyer_queue")
    public Queue queue() {
        return  new Queue(QUEUE);
    }

    @Bean(name = "buyer_exchange")
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean(name = "buyer_binding")
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);
    }

    @Bean(name = "buyer_messageConverter")
    public MessageConverter messageConverter() {
        return  new Jackson2JsonMessageConverter();
    }

    @Bean(name = "buyer_template")
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return  template;
    }

}
