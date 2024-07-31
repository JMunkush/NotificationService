package io.munkush.app.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class UserResponseDto {
    private String id;
    private LocalDateTime dateTime;
    private List<String> notifications;
    private String firstname;
    private String lastname;
    private String email;
}
