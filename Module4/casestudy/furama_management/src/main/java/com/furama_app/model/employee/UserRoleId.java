package com.furama_app.model.employee;

import java.io.Serializable;
import java.util.Objects;

public class UserRoleId implements Serializable {
    private AppUser appUser;
    private AppRole appRole;

    public UserRoleId() {
    }

    public UserRoleId(AppUser appUser, AppRole appRole) {
        this.appUser = appUser;
        this.appRole = appRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleId that = (UserRoleId) o;
        return Objects.equals(appUser, that.appUser) &&
                Objects.equals(appRole, that.appRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUser, appRole);
    }
}
