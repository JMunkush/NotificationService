package io.munkush.app.mapper;

import io.munkush.app.dto.RegisterRequestDto;
import io.munkush.app.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RequestToUserMapper implements Mapper<RegisterRequestDto, User> {

    @Override
    public User map(RegisterRequestDto addSource) {

        return User.builder()
                .email(addSource.getEmail())
                .firstname(addSource.getFirstname())
                .notifications(new ArrayList<>())
                .lastname(addSource.getLastname())
                .build();

    }
}
