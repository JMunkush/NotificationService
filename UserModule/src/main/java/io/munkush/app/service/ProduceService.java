package io.munkush.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static io.munkush.app.CommonQueue.NOTIFICATION;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProduceService {

    private final RabbitTemplate rabbitTemplate;


    public void sendNotification(String notification){
        log.info("sent notification: " + notification);
        rabbitTemplate.convertAndSend(NOTIFICATION, notification);
    }

}
