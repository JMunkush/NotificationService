package io.munkush.app.mapper;

import io.munkush.app.dto.UserResponseDto;
import io.munkush.app.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
public class UserToResponseMapper implements Mapper<User, UserResponseDto> {
    @Override
    public UserResponseDto map(User addSource) {
        return UserResponseDto.builder()
                .id(addSource.getId())
                .notifications(addSource.getNotifications())
                .dateTime(LocalDateTime.now())
                .lastname(addSource.getLastname())
                .firstname(addSource.getFirstname())
                .email(addSource.getEmail())
                .build();
    }
}
