package com.furama_app.service.employee;

import com.furama_app.model.employee.Employee;
import com.furama_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Employee employee) {
    employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> findAllByNameContaining(String name) {
        return employeeRepository.findAllByNameContaining(name);
    }
}
