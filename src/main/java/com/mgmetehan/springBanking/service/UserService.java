package com.mgmetehan.springBanking.service;

import com.mgmetehan.springBanking.dto.dtoUser.UserCreateDto;
import com.mgmetehan.springBanking.dto.dtoUser.UserViewDto;

import java.util.List;

public interface UserService {
    UserViewDto createUser(UserCreateDto newUser);

    List<UserViewDto> getAllUsers();
}
