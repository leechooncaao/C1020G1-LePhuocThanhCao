package com.furama_app.model.employee;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class AppUser {
    @Id
    @Column(name = "username", length = 255, nullable = false)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

}
