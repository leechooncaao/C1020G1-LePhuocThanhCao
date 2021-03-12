package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "app_user", uniqueConstraints = {@UniqueConstraint(columnNames = "user_name")})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "user_name", length = 36, nullable = false)
    private String userName;

    @Column(name = "encrypted_password", length = 128, nullable = false)
    private String encryptedPassword;

    @Column(name = "enabled", length = 1, nullable = false)
    private boolean enabled;

    public AppUser() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
