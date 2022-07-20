package com.mgmetehan.springBanking.service.serviceImpl;

import com.mgmetehan.springBanking.repository.UserRepository;
import com.mgmetehan.springBanking.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
