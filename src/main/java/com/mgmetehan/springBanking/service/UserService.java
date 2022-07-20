package com.mgmetehan.springBanking.service;

import com.mgmetehan.springBanking.dto.dtoUser.UserCreateDto;
import com.mgmetehan.springBanking.dto.dtoUser.UserUpdateDto;
import com.mgmetehan.springBanking.dto.dtoUser.UserViewDto;

import java.util.List;

public interface UserService {
    UserViewDto getUserById(Long id);

    List<UserViewDto> getAllUsers();

    UserViewDto createUser(UserCreateDto newUser);

    UserViewDto updateUser(Long id, UserUpdateDto updateUser);

    void deleteUser(Long id);
}
