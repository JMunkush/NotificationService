package io.munkush.com.config;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.munkush.app.CommonQueue.NOTIFICATION;

@Configuration
public class RabbitMQConfiguration {
    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public Queue notification(){
        return new Queue(NOTIFICATION);
    }

}
