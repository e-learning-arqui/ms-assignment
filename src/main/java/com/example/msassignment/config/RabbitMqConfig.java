package com.example.msassignment.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange");

    }

    @Bean
    public Queue progressQueue() {
        return new Queue("progress.queue");
    }

    @Bean
    public Binding bindingProgress(TopicExchange topicExchange, Queue progressQueue) {
        return BindingBuilder.bind(progressQueue)
                .to(topicExchange)
                .with("progress.routingKey");
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
