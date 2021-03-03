package com.validation_demo.service.impl;

import com.validation_demo.model.User;
import com.validation_demo.repository.UserRepository;
import com.validation_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}
