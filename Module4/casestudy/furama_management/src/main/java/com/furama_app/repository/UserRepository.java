package com.furama_app.repository;

import com.furama_app.model.employee.AppUser;
import com.furama_app.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByUsername(String username);

    AppUser findByEmployee(Employee employee);

    AppUser findByEmployee_Id (Integer id);


}
