package io.munkush.app.controller;

import io.munkush.app.dto.RegisterRequestDto;
import io.munkush.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody RegisterRequestDto requestDto){


        userService.save(requestDto);


        return ResponseEntity.ok("created");
    }
}
