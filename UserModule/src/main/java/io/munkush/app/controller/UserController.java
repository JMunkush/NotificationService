package io.munkush.app.controller;

import io.munkush.app.dto.RegisterRequestDto;
import io.munkush.app.dto.UserResponseDto;
import io.munkush.app.service.ProduceService;
import io.munkush.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ProduceService produceService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody RegisterRequestDto requestDto){


        // Сохранение в базу
        userService.save(requestDto);

        // Отправка сообщение в очередь
        produceService.sendNotification(requestDto.getEmail() + ":NEW-USER");

        return ResponseEntity.ok("created");
    }


    @GetMapping("getInfo")
    public ResponseEntity<UserResponseDto> getInfo(){
        var id = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(userService.getById(id));
    }


}
