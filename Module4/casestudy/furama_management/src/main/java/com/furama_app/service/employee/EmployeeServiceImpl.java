package com.furama_app.service.employee;

import com.furama_app.model.employee.AppRole;
import com.furama_app.model.employee.AppUser;
import com.furama_app.model.employee.Employee;
import com.furama_app.model.employee.UserRole;
import com.furama_app.repository.EmployeeRepository;
import com.furama_app.repository.RoleRepository;
import com.furama_app.repository.UserRepository;
import com.furama_app.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);

        AppRole role = roleRepository.findByName("member");

        AppUser oldUser = userRepository.findByEmployee_Id(employee.getId());

        AppUser newUser = new AppUser(employee.getEmail(), employee);

        UserRole newUserRole = new UserRole(newUser, role);

        if (oldUser != null) {
            UserRole oldUserRole = userRoleRepository.findByAppUser_Username(oldUser.getUsername());
            userRoleRepository.delete(oldUserRole);
            userRepository.delete(oldUser);

        }
        userRepository.save(newUser);
        userRoleRepository.save(newUserRole);
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

    @Override
    public Boolean emailIsUnique(String email) {
        List<Employee> employees = employeeRepository.findAll();

        for (Employee employee : employees){
            if(email.equals(employee.getEmail())){
                return false;
            }
        }

        return true;
    }

}
