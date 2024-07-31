package io.munkush.app;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class UserModuleMainClass {



    public static void main(String[] args) {
        SpringApplication.run(UserModuleMainClass.class, args);
    }


}
