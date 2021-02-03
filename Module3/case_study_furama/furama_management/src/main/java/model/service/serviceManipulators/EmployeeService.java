package model.service.serviceManipulators;

import model.bean.Customer;
import model.bean.Employee;
import model.repository.IManipulation;
import model.repository.manipulators.EmployeeManipulator;
import model.service.IService;
import model.service.validation.CommonValidator;
import model.service.validation.PersonValidator;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IService<Employee> {
    IManipulation<Employee> employeeIManipulator = new EmployeeManipulator();

    @Override
    public String add(Employee employee) throws SQLException {
        String result = validateInput(employee);

        if(result.equals("OK"))
            employeeIManipulator.add(employee);

        return result;
    }

    @Override
    public Employee findById(int id) throws SQLException {
        return employeeIManipulator.findById(id);
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        return employeeIManipulator.findAll();
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return employeeIManipulator.deleteById(id);
    }

    @Override
    public String update(Employee employee) throws SQLException {
        String result = validateInput(employee);

        if(result.equals("OK"))
            employeeIManipulator.update(employee);

        return result;
    }

    @Override
    public List<Employee> searchByName(String name) throws SQLException {
        return employeeIManipulator.searchByName(name);
    }

    private String validateInput(Employee employee){
        if (!PersonValidator.validateEmail(employee.getEmail()))
            return "Email is not valid !";

        if(!PersonValidator.validateIdCard(employee.getIdCard()))
            return "ID Card is not valid!";

        if(!PersonValidator.validatePhone(employee.getPhone()))
            return "Phone number is not valid!";

        if(!CommonValidator.validateDate(employee.getBirthday()))
            return "Birthday is not valid!";

        if(!CommonValidator.validateNumber(employee.getSalary()))
            return "Salary is not valid!";

        return "OK";
    }
}
