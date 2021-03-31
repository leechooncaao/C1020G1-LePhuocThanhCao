package com.furama_server.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class AppUser {
    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password",length = 128, nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appUser")
    private List<UserRole> userRoles;

    public AppUser() {
    }

    public AppUser(String email, Employee employee) {
        this.username = email;
        this.password = "$2a$10$JDrCRHIlc3yeeCl9hgDTDed/niw6wHd1KPnS6m6/OTC/g1A/gbE0y";
        this.employee = employee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
