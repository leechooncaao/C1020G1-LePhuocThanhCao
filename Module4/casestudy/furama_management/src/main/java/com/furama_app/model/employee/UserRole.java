package com.furama_app.model.employee;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_role")
@IdClass(UserRoleId.class)
public class UserRole implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    private AppUser appUser;

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    private AppRole appRole;

    public UserRole() {
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
}
