package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "app_role", uniqueConstraints = {@UniqueConstraint(columnNames = "role_name")})
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @Column(name = "role_name",length = 30, nullable = false)
    private String roleName;

    public AppRole() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
