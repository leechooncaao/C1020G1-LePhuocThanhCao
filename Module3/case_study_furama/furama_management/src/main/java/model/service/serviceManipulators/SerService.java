package model.service.serviceManipulators;

import model.bean.Service;
import model.repository.IManipulation;
import model.repository.manipulators.ServiceManipulator;
import model.service.IService;
import model.service.validation.CommonValidator;

import java.sql.SQLException;
import java.util.List;

public class SerService implements IService<Service> {
    IManipulation<Service> serviceIManipulator = new ServiceManipulator();
    @Override
    public String add(Service service) throws SQLException {
        var result = validateInput(service);

        if(result.equals("OK"))
            serviceIManipulator.add(service);

        return result;
    }

    @Override
    public Service findById(int id) throws SQLException {
        return serviceIManipulator.findById(id);
    }

    @Override
    public List<Service> findAll() throws SQLException {
        return serviceIManipulator.findAll();
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return serviceIManipulator.deleteById(id);
    }

    @Override
    public String update(Service service) throws SQLException {
        String result = validateInput(service);

        if(result.equals("OK"))
            serviceIManipulator.update(service);

        return result;
    }

    @Override
    public List<Service> searchByName(String name) throws SQLException {
        return null;
    }

    private String validateInput(Service service){
        if(!CommonValidator.validateNumber(service.getArea()))
            return "Area is not valid !";

        if(!CommonValidator.validateNumber(service.getCost()))
            return "Cost is not valid !";

        if(!CommonValidator.validateNumber(service.getMaxPeople()))
            return "The number of people is not valid !";

        if(!CommonValidator.validateNumber(service.getNumberFloor()))
            return "Number of floor is not valid !";

        return "OK";
    }
}
