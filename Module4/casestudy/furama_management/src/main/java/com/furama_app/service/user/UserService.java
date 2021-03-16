package com.furama_app.service.user;

import com.furama_app.model.employee.AppUser;

public interface UserService {
    void save(AppUser user);

    AppUser findByUsername(String username);

}
