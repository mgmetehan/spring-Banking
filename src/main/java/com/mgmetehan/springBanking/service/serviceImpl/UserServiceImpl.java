package com.mgmetehan.springBanking.service.serviceImpl;

import com.mgmetehan.springBanking.dto.dtoUser.UserCreateDto;
import com.mgmetehan.springBanking.dto.dtoUser.UserViewDto;
import com.mgmetehan.springBanking.model.User;
import com.mgmetehan.springBanking.repository.UserRepository;
import com.mgmetehan.springBanking.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserViewDto createUser(UserCreateDto newUser) {
        final User user = userRepository.save(new User(newUser.getUsername(), newUser.getSurname(), newUser.getPassword(),
                newUser.getIdentificationNumber(), newUser.getCity(), newUser.getMobileNumber(), newUser.getEmail()));
        return UserViewDto.of(user);
    }

    @Override
    public List<UserViewDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserViewDto::of).collect(Collectors.toList());

    }
}
