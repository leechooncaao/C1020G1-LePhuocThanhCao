package model.repository.manipulators;

import model.bean.Customer;
import model.repository.BaseRepository;
import model.repository.IManipulation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManipulator implements IManipulation<Customer> {
    private final BaseRepository baseRepository = new BaseRepository();
    private final String SQL_INSERT = "INSERT INTO customer(customer_code,\n" +
            "customer_type_id,\n" +
            "customer_name,\n" +
            "customer_birthday,\n" +
            "customer_gender,\n" +
            "customer_id_card,\n" +
            "customer_phone,\n" +
            "customer_email,\n" +
            "customer_address)\n" +
            "VALUES(?,?,?,?,?,?,?,?,?)";
    private final String SQL_FIND_BY_ID = "SELECT \n" +
            "cus.customer_id,\n" +
            "cus.customer_code,\n" +
            "ct.customer_type_name AS `type`,\n" +
            "cus.customer_name,\n" +
            "cus.customer_birthday,\n" +
            "cus.customer_gender,\n" +
            "cus.customer_id_card,\n" +
            "cus.customer_phone,\n" +
            "cus.customer_email,\n" +
            "cus.customer_address\n" +
            "FROM customer cus\n" +
            "JOIN customer_type ct USING (customer_type_id)\n" +
            "WHERE cus.customer_id = ?";
    private final String SQL_FIND_ALL = "SELECT \n" +
            "cus.customer_id,\n" +
            "cus.customer_code,\n" +
            "ct.customer_type_name AS `type`,\n" +
            "cus.customer_name,\n" +
            "cus.customer_birthday,\n" +
            "cus.customer_gender,\n" +
            "cus.customer_id_card,\n" +
            "cus.customer_phone,\n" +
            "cus.customer_email,\n" +
            "cus.customer_address\n" +
            "FROM customer cus\n" +
            "JOIN customer_type ct USING (customer_type_id)";
    private final String SQL_UPDATE = "UPDATE customer \n" +
            "SET customer_code = ?,\n " +
            "customer_type_id = ?,\n" +
            "customer_name = ?,\n" +
            "customer_birthday = ?,\n" +
            "customer_gender = ?,\n" +
            "customer_id_card = ?,\n" +
            "customer_phone = ?,\n" +
            "customer_email = ?,\n" +
            "customer_address = ?\n" +
            "WHERE customer_id = ?";
    private final String SQL_DELETE_CUSTOMER = "DELETE FROM customer WHERE customer_id = ?";
    private final String SQL_SEARCH_BY_NAME = "SELECT \n" +
            "cus.customer_id,\n" +
            "cus.customer_code,\n" +
            "ct.customer_type_name AS `type`,\n" +
            "cus.customer_name,\n" +
            "cus.customer_birthday,\n" +
            "cus.customer_gender,\n" +
            "cus.customer_id_card,\n" +
            "cus.customer_phone,\n" +
            "cus.customer_email,\n" +
            "cus.customer_address\n" +
            "FROM customer cus\n" +
            "JOIN customer_type ct USING (customer_type_id)\n" +
            "WHERE cus.customer_name LIKE ?";

    @Override
    public void add(Customer customer) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_INSERT);
        prepareStatement.setString(1, customer.getCode());
        prepareStatement.setString(2, customer.getType());
        prepareStatement.setString(3, customer.getName());
        prepareStatement.setString(4, customer.getBirthday());
        prepareStatement.setString(5, customer.getGender());
        prepareStatement.setString(6, customer.getIdCard());
        prepareStatement.setString(7, customer.getPhone());
        prepareStatement.setString(8, customer.getEmail());
        prepareStatement.setString(9, customer.getAddress());

        prepareStatement.executeUpdate();
    }

    @Override
    public Customer findById(int id) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_BY_ID);

        prepareStatement.setInt(1, id);

        var resultSet = prepareStatement.executeQuery();
        if (resultSet.next()) {
            String code = resultSet.getString("customer_code");
            String type = resultSet.getString("type");
            String name = resultSet.getString("customer_name");
            String birthday = resultSet.getString("customer_birthday");
            String gender = resultSet.getString("customer_gender");
            String idCard = resultSet.getString("customer_id_card");
            String phone = resultSet.getString("customer_phone");
            String email = resultSet.getString("customer_email");
            String address = resultSet.getString("customer_address");

            return new Customer(id, code, type, name, birthday, gender, idCard, phone, email, address);
        }


        return null;
    }

    @Override
    public List<Customer> findAll() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_ALL);

        var resultSet = prepareStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("customer_id");
            String code = resultSet.getString("customer_code");
            String type = resultSet.getString("type");
            String name = resultSet.getString("customer_name");
            String birthday = resultSet.getString("customer_birthday");
            String gender = resultSet.getString("customer_gender");
            String idCard = resultSet.getString("customer_id_card");
            String phone = resultSet.getString("customer_phone");
            String email = resultSet.getString("customer_email");
            String address = resultSet.getString("customer_address");

            customerList.add(new Customer(id, code, type, name, birthday, gender, idCard, phone, email, address));
        }

        return customerList;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_DELETE_CUSTOMER);

        prepareStatement.setInt(1, id);
        var result = prepareStatement.executeUpdate();

        if (result > 0)
            return true;
        return false;
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_UPDATE);

        prepareStatement.setString(1, customer.getCode());
        prepareStatement.setString(2, customer.getType());
        prepareStatement.setString(3, customer.getName());
        prepareStatement.setString(4, customer.getBirthday());
        prepareStatement.setString(5, customer.getGender());
        prepareStatement.setString(6, customer.getIdCard());
        prepareStatement.setString(7, customer.getPhone());
        prepareStatement.setString(8, customer.getEmail());
        prepareStatement.setString(9, customer.getAddress());
        prepareStatement.setInt(10, customer.getId());

        var result = prepareStatement.executeUpdate();
        if (result > 0)
            return true;

        return false;
    }

    @Override
    public List<Customer> searchByName(String name) throws SQLException {
        name = "%" + name + "%";
        List<Customer> customerList = new ArrayList<>();
        var preparedStatement = baseRepository.getConnection().prepareStatement(SQL_SEARCH_BY_NAME);
        preparedStatement.setString(1, name);

        var resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("customer_id");
            String code = resultSet.getString("customer_code");
            String type = resultSet.getString("type");
            String customer_name = resultSet.getString("customer_name");
            String birthday = resultSet.getString("customer_birthday");
            String gender = resultSet.getString("customer_gender");
            String idCard = resultSet.getString("customer_id_card");
            String phone = resultSet.getString("customer_phone");
            String email = resultSet.getString("customer_email");
            String address = resultSet.getString("customer_address");

            customerList.add(new Customer(id, code, type, customer_name, birthday, gender, idCard, phone, email, address));
        }
        return customerList;
    }
}
