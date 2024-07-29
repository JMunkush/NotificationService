package io.munkush.app.dto;

import lombok.Data;

@Data
public class RegisterRequestDto {
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
}
