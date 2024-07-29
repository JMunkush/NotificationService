package io.munkush.app;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class UserServiceMainClass {



    public static void main(String[] args) {
        SpringApplication.run(UserServiceMainClass.class, args);
    }


}
