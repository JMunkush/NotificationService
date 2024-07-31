package io.munkush.com.service;

import io.munkush.com.model.User;
import io.munkush.com.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


import static io.munkush.app.CommonQueue.NOTIFICATION;


@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumeService {

    private final UserRepository userRepository;
    @RabbitListener(queues = NOTIFICATION)
    public void consume(String notification){
        log.info("consumed notification: " + notification);

        var users = userRepository.findAll();

        users.forEach(r -> {
            if(notification.split(":")[0].equals(r.getEmail())) {
                r.getNotifications().add("Вы добавлены в систему");
            } else {
                r.getNotifications().add(notification);
            }
        });

        userRepository.saveAll(users);
    }




}
