package model.service.serviceManipulators;

import model.bean.Customer;
import model.repository.IManipulation;
import model.repository.manipulators.CustomerManipulator;
import model.service.IService;
import model.service.validation.CommonValidator;
import model.service.validation.PersonValidator;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements IService<Customer> {
    IManipulation<Customer> customerManipulator = new CustomerManipulator();

    @Override
    public String add(Customer customer) throws SQLException {
        String result = validateInput(customer);
        if(result.equals("OK"))
            customerManipulator.add(customer);

        return result;
    }

    @Override
    public Customer findById(int id) throws SQLException {
        return customerManipulator.findById(id);
    }

    @Override
    public List<Customer> findAll() throws SQLException {
        return customerManipulator.findAll();
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return customerManipulator.deleteById(id);
    }

    @Override
    public String update(Customer customer) throws SQLException {
        String result = validateInput(customer);

        if(result.equals("OK"))
            customerManipulator.update(customer);

        return result;
    }

    @Override
    public List<Customer> searchByName(String name) throws SQLException {
        return customerManipulator.searchByName(name);
    }

    private String validateInput(Customer customer){
        if(!PersonValidator.validateCustomerCode(customer.getCode()))
            return "Customer Code is not valid !";

        if (!PersonValidator.validateEmail(customer.getEmail()))
            return "Email is not valid !";

        if(!PersonValidator.validateIdCard(customer.getIdCard()))
            return "ID Card is not valid!";

        if(!PersonValidator.validatePhone(customer.getPhone()))
            return "Phone number is not valid!";

        if(!CommonValidator.validateDate(customer.getBirthday()))
            return "Birthday is not valid";

        return "OK";
    }
}
