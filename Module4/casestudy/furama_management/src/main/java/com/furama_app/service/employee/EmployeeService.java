package com.furama_app.service.employee;

import com.furama_app.model.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(Integer id);

    void delete(Employee employee);

    List<Employee> findAllByNameContaining(String name);
}
