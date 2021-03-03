package com.validation_demo.service;

import com.validation_demo.model.User;

public interface UserService {
    void save(User user);

    User findById(Integer id);
}
