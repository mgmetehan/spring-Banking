package com.mgmetehan.springBanking.service.serviceImpl;

import com.mgmetehan.springBanking.dto.dtoUser.UserCreateDto;
import com.mgmetehan.springBanking.dto.dtoUser.UserUpdateDto;
import com.mgmetehan.springBanking.dto.dtoUser.UserViewDto;
import com.mgmetehan.springBanking.exception.NotFoundException;
import com.mgmetehan.springBanking.model.User;
import com.mgmetehan.springBanking.repository.UserRepository;
import com.mgmetehan.springBanking.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserViewDto getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return UserViewDto.of(user);
    }

    @Override
    public List<UserViewDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserViewDto::of).collect(Collectors.toList());
    }

    @Override
    public UserViewDto createUser(UserCreateDto newUser) {
        final User user = userRepository.save(new User(newUser.getUsername(), newUser.getSurname(), newUser.getPassword(),
                newUser.getIdentificationNumber(), newUser.getCity(), newUser.getMobileNumber(), newUser.getEmail()));
        return UserViewDto.of(user);
    }

    @Override
    public UserViewDto updateUser(Long id, UserUpdateDto updateUser) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));

        user.setUsername(updateUser.getUsername());
        user.setSurname(updateUser.getSurname());
        user.setPassword(updateUser.getPassword());
        user.setIdentificationNumber(updateUser.getIdentificationNumber());
        user.setCity(updateUser.getCity());
        user.setMobileNumber(updateUser.getMobileNumber());
        user.setEmail(updateUser.getEmail());
        user.setCreatedAtDate(updateUser.getCreatedAtDate());

        final User update = userRepository.save(user);
        return UserViewDto.of(update);
    }

    @Override
    public void deleteUser(Long id) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        userRepository.deleteById(id);
    }
}
