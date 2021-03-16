package com.furama_app.repository;

import com.furama_app.model.employee.AppUser;
import com.furama_app.model.employee.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole findByAppUser(AppUser user);

    UserRole findByAppUser_Username(String username);
}
