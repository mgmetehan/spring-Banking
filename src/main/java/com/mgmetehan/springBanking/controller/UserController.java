package com.mgmetehan.springBanking.controller;

import com.mgmetehan.springBanking.dto.dtoUser.UserCreateDto;
import com.mgmetehan.springBanking.dto.dtoUser.UserViewDto;
import com.mgmetehan.springBanking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserViewDto>> getAllUsers() {
        final List<UserViewDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserCreateDto newUser){
        userService.createUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
