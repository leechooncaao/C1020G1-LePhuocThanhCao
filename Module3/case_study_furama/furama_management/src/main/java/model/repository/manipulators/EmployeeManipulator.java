package model.repository.manipulators;

import model.bean.Employee;
import model.repository.BaseRepository;
import model.repository.IManipulation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManipulator implements IManipulation<Employee> {
    private final BaseRepository baseRepository = new BaseRepository();
    private final String SQL_INSERT = "INSERT INTO employee(employee_name,\n" +
            "employee_birthday,\n" +
            "employee_id_card,\n" +
            "employee_salary,\n" +
            "employee_phone,\n" +
            "employee_email,\n" +
            "employee_address,\n" +
            "position_id,\n" +
            "education_degree_id,\n" +
            "division_id,\n" +
            "username) \n " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private final String SQL_FIND_BY_ID = "SELECT \n" +
            "e.employee_id,\n" +
            "e.employee_name,\n" +
            "e.employee_birthday,\n" +
            "e.employee_id_card,\n" +
            "e.employee_salary,\n" +
            "e.employee_phone,\n" +
            "e.employee_email,\n" +
            "e.employee_address,\n" +
            "pos.position_name,\n" +
            "ed.education_degree_name,\n" +
            "divi.division_name,\n" +
            "e.username\n" +
            "FROM employee e\n" +
            "JOIN position pos USING (position_id)\n" +
            "JOIN education_degree ed USING (education_degree_id)\n" +
            "JOIN division divi USING (division_id)" +
            "WHERE employee_id = ?";
    private final String SQL_FIND_ALL = "SELECT \n" +
            "e.employee_id,\n" +
            "e.employee_name,\n" +
            "e.employee_birthday,\n" +
            "e.employee_id_card,\n" +
            "e.employee_salary,\n" +
            "e.employee_phone,\n" +
            "e.employee_email,\n" +
            "e.employee_address,\n" +
            "pos.position_name,\n" +
            "ed.education_degree_name,\n" +
            "divi.division_name,\n" +
            "e.username\n" +
            "FROM employee e\n" +
            "JOIN position pos USING (position_id)\n" +
            "JOIN education_degree ed USING (education_degree_id)\n" +
            "JOIN division divi USING (division_id)\n" +
            "ORDER BY e.employee_id";
    private final String SQL_UPDATE = "UPDATE employee \n" +
            "SET employee_name = ?,\n" +
            "employee_birthday = ?,\n" +
            "employee_id_card = ?,\n" +
            "employee_salary = ?,\n" +
            "employee_phone = ?,\n" +
            "employee_email = ?,\n" +
            "employee_address = ?,\n" +
            "position_id = ?,\n" +
            "education_degree_id = ?,\n" +
            "division_id = ?,\n" +
            "username = ?\n" +
            "WHERE employee_id = ?";
    private final String SQL_DELETE_EMPLOYEE = "DELETE FROM employee WHERE employee_id = ?";
    private final String SQL_SEARCH_BY_NAME = "SELECT \n" +
            "e.employee_id,\n" +
            "e.employee_name,\n" +
            "e.employee_birthday,\n" +
            "e.employee_id_card,\n" +
            "e.employee_salary,\n" +
            "e.employee_phone,\n" +
            "e.employee_email,\n" +
            "e.employee_address,\n" +
            "pos.position_name,\n" +
            "ed.education_degree_name,\n" +
            "divi.division_name,\n" +
            "e.username\n" +
            "FROM employee e\n" +
            "JOIN position pos USING (position_id)\n" +
            "JOIN education_degree ed USING (education_degree_id)\n" +
            "JOIN division divi USING (division_id)\n" +
            "WHERE e.employee_name LIKE ? \n" +
            "ORDER BY e.employee_id";

    @Override
    public void add(Employee employee) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_INSERT);
        prepareStatement.setString(1, employee.getName());
        prepareStatement.setString(2, employee.getBirthday());
        prepareStatement.setString(3, employee.getIdCard());
        prepareStatement.setDouble(4, employee.getSalary());
        prepareStatement.setString(5, employee.getPhone());
        prepareStatement.setString(6, employee.getEmail());
        prepareStatement.setString(7, employee.getAddress());
        prepareStatement.setString(8, employee.getPosition());
        prepareStatement.setString(9, employee.getDegree());
        prepareStatement.setString(10, employee.getDivision());
        prepareStatement.setString(11, employee.getUserName());

        prepareStatement.executeUpdate();
    }

    public List<Employee> findAll() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_ALL);

        var resultSet = prepareStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("employee_id");
            String name = resultSet.getString("employee_name");
            String birthday = resultSet.getString("employee_birthday");
            String idCard = resultSet.getString("employee_id_card");
            Double salary = resultSet.getDouble("employee_salary");
            String phone = resultSet.getString("employee_phone");
            String email = resultSet.getString("employee_email");
            String address = resultSet.getString("employee_address");
            String position = resultSet.getString("position_name");
            String degree = resultSet.getString("education_degree_name");
            String division = resultSet.getString("division_name");
            String userName = resultSet.getString("username");

            employeeList.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, position, degree, division, userName));
        }

        return employeeList;
    }

    @Override
    public Employee findById(int id) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_BY_ID);

        prepareStatement.setInt(1, id);

        var resultSet = prepareStatement.executeQuery();
        if (resultSet.next())
            return new Employee(resultSet.getInt("employee_id"),
                    resultSet.getString("employee_name"),
                    resultSet.getString("employee_birthday"),
                    resultSet.getString("employee_id_card"),
                    resultSet.getDouble("employee_salary"),
                    resultSet.getString("employee_phone"),
                    resultSet.getString("employee_email"),
                    resultSet.getString("employee_address"),
                    resultSet.getString("position_name"),
                    resultSet.getString("education_degree_name"),
                    resultSet.getString("division_name"),
                    resultSet.getString("username"));

        return null;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_DELETE_EMPLOYEE);

        prepareStatement.setInt(1, id);
        var result = prepareStatement.executeUpdate();

        if (result > 0)
            return true;
        return false;
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_UPDATE);

        prepareStatement.setString(1, employee.getName());
        prepareStatement.setString(2, employee.getBirthday());
        prepareStatement.setString(3, employee.getIdCard());
        prepareStatement.setDouble(4, employee.getSalary());
        prepareStatement.setString(5, employee.getPhone());
        prepareStatement.setString(6, employee.getEmail());
        prepareStatement.setString(7, employee.getAddress());
        prepareStatement.setString(8, employee.getPosition());
        prepareStatement.setString(9, employee.getDegree());
        prepareStatement.setString(10, employee.getDivision());
        prepareStatement.setString(11, employee.getUserName());
        prepareStatement.setInt(12, employee.getId());

        var result = prepareStatement.executeUpdate();
        if (result > 0)
            return true;

        return false;
    }

    @Override
    public List<Employee> searchByName(String name) throws SQLException {
        name = "%" + name + "%";
        List<Employee> employeeList = new ArrayList<>();
        var preparedStatement = baseRepository.getConnection().prepareStatement(SQL_SEARCH_BY_NAME);
        preparedStatement.setString(1,name);

        var resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("employee_id");
            String employee_name = resultSet.getString("employee_name");
            String birthday = resultSet.getString("employee_birthday");
            String idCard = resultSet.getString("employee_id_card");
            Double salary = resultSet.getDouble("employee_salary");
            String phone = resultSet.getString("employee_phone");
            String email = resultSet.getString("employee_email");
            String address = resultSet.getString("employee_address");
            String position = resultSet.getString("position_name");
            String degree = resultSet.getString("education_degree_name");
            String division = resultSet.getString("division_name");
            String userName = resultSet.getString("username");

            employeeList.add(new Employee(id, employee_name, birthday, idCard, salary, phone, email, address, position, degree, division, userName));
        }
        return employeeList;
    }
}
