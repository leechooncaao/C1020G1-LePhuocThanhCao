package model.repository.manipulators;

import model.bean.Service;
import model.repository.BaseRepository;
import model.repository.IManipulation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceManipulator implements IManipulation<Service> {
    private final BaseRepository baseRepository = new BaseRepository();
    private final String SQL_INSERT = "INSERT INTO service(\n" +
            "service_name,\n" +
            "service_area,\n" +
            "service_cost,\n" +
            "service_max_people,\n" +
            "rent_type_id,\n" +
            "service_type_id,\n" +
            "standard_room,\n" +
            "description_other_convenience,\n" +
            "pool_area,\n" +
            "number_of_floors)\n" +
            "VALUES(?,?,?,?,?,?,?,?,?,?)";
    private final String SQL_FIND_BY_ID = "SELECT \n" +
            "ser.service_id,\n" +
            "ser.service_name,\n" +
            "ser.service_area,\n" +
            "ser.service_cost,\n" +
            "ser.service_max_people,\n" +
            "rt.rent_type_name,\n" +
            "st.service_type_name,\n" +
            "ser.standard_room,\n" +
            "ser.description_other_convenience,\n" +
            "ser.pool_area,\n" +
            "ser.number_of_floors\n" +
            "FROM service ser\n" +
            "JOIN service_type st USING (service_type_id)\n" +
            "JOIN rent_type rt USING (rent_type_id)\n" +
            "WHERE service_id = ?";
    private final String SQL_FIND_ALL = "SELECT \n" +
            "ser.service_id,\n" +
            "ser.service_name,\n" +
            "ser.service_area,\n" +
            "ser.service_cost,\n" +
            "ser.service_max_people,\n" +
            "rt.rent_type_name,\n" +
            "st.service_type_name,\n" +
            "ser.standard_room,\n" +
            "ser.description_other_convenience,\n" +
            "ser.pool_area,\n" +
            "ser.number_of_floors\n" +
            "FROM service ser\n" +
            "JOIN service_type st USING (service_type_id)\n" +
            "JOIN rent_type rt USING (rent_type_id)\n" +
            "ORDER BY service_id";
    private final String SQL_DELETE_SERVICE = "DELETE FROM service\n" +
            "WHERE service_id = ?";
    private final String SQL_UPDATE = "UPDATE service\n" +
            "SET \n" +
            "service_name = ?,\n" +
            "service_area = ?,\n" +
            "service_cost = ?,\n" +
            "service_max_people = ?,\n" +
            "rent_type_id = ?,\n" +
            "service_type_id = ?,\n" +
            "standard_room = ?,\n" +
            "description_other_convenience = ?,\n" +
            "pool_area = ?,\n" +
            "number_of_floors = ?\n" +
            "WHERE service_id = ? ";

    @Override
    public void add(Service service) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_INSERT);
        prepareStatement.setString(1, service.getName());
        prepareStatement.setInt(2, service.getArea());
        prepareStatement.setDouble(3, service.getCost());
        prepareStatement.setInt(4, service.getMaxPeople());
        prepareStatement.setString(5, service.getRentType());
        prepareStatement.setString(6, service.getServiceType());
        prepareStatement.setString(7, service.getStandardRoom());
        prepareStatement.setString(8, service.getDescription());
        prepareStatement.setDouble(9, service.getPoolArea());
        prepareStatement.setInt(10, service.getNumberFloor());

        prepareStatement.executeUpdate();
    }

    @Override
    public Service findById(int id) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_BY_ID);

        prepareStatement.setInt(1, id);

        var resultSet = prepareStatement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("service_name");
            int area = resultSet.getInt("service_area");
            Double cost = resultSet.getDouble("service_cost");
            int maxPeople = resultSet.getInt("service_max_people");
            String rentType = resultSet.getString("rent_type_name");
            String serviceType = resultSet.getString("service_type_name");
            String standardRoom = resultSet.getString("standard_room");
            String description = resultSet.getString("description_other_convenience");
            Double poolArea = resultSet.getDouble("pool_area");
            int numberFloor = resultSet.getInt("number_of_floors");


            return new Service(id, name, area, cost, maxPeople, rentType, serviceType, standardRoom, description, poolArea, numberFloor);
        }

        return null;
    }

    @Override
    public List<Service> findAll() throws SQLException {
        List<Service> serviceList = new ArrayList<>();
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_ALL);

        var resultSet = prepareStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("service_id");
            String name = resultSet.getString("service_name");
            int area = resultSet.getInt("service_area");
            Double cost = resultSet.getDouble("service_cost");
            int maxPeople = resultSet.getInt("service_max_people");
            String rentType = resultSet.getString("rent_type_name");
            String serviceType = resultSet.getString("service_type_name");
            String standardRoom = resultSet.getString("standard_room");
            String description = resultSet.getString("description_other_convenience");
            Double poolArea = resultSet.getDouble("pool_area");
            int numberFloor = resultSet.getInt("number_of_floors");

            serviceList.add(new Service(id, name, area, cost, maxPeople, rentType, serviceType, standardRoom, description, poolArea, numberFloor));
        }

        return serviceList;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_DELETE_SERVICE);

        prepareStatement.setInt(1, id);
        var result = prepareStatement.executeUpdate();

        if (result > 0)
            return true;
        return false;
    }

    @Override
    public boolean update(Service service) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_UPDATE);

        prepareStatement.setString(1, service.getName());
        prepareStatement.setInt(2, service.getArea());
        prepareStatement.setDouble(3, service.getCost());
        prepareStatement.setInt(4, service.getMaxPeople());
        prepareStatement.setString(5, service.getRentType());
        prepareStatement.setString(6, service.getServiceType());
        prepareStatement.setString(7, service.getStandardRoom());
        prepareStatement.setString(8, service.getDescription());
        prepareStatement.setDouble(9, service.getPoolArea());
        prepareStatement.setInt(10, service.getNumberFloor());
        prepareStatement.setInt(11, service.getId());

        var result = prepareStatement.executeUpdate();
        if (result > 0)
            return true;

        return false;
    }

    @Override
    public List<Service> searchByName(String name) throws SQLException {
        return null;
    }
}
