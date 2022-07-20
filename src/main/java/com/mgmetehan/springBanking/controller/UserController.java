package com.mgmetehan.springBanking.controller;

import com.mgmetehan.springBanking.dto.dtoUser.UserCreateDto;
import com.mgmetehan.springBanking.dto.dtoUser.UserUpdateDto;
import com.mgmetehan.springBanking.dto.dtoUser.UserViewDto;
import com.mgmetehan.springBanking.service.UserService;
import com.mgmetehan.springBanking.shared.GenericResponse;
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

    @GetMapping("/{id}")
    public ResponseEntity<UserViewDto> getUserById(@PathVariable("id") Long id) {
        UserViewDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserViewDto>> getAllUsers() {
        final List<UserViewDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserCreateDto newUser) {
        userService.createUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserViewDto> updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateDto updateUser) {
        final UserViewDto user = userService.updateUser(id, updateUser);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse("User Deleted"));
    }

}
