package model.dao;

import model.bean.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDAO {
    private final BaseRepository baseRepository = new BaseRepository();
    private final String SQL_INSERT_USER = "INSERT INTO users(`name`, email, country) " +
                                            "VALUES(?,?,?)";
    private final String SQL_SELECT_USER = "SELECT * " +
                                            "FROM users " +
                                            "WHERE id = ?";
    private final String SQL_SELECT_ALL_USER = "SELECT * FROM users";
    private final String SQL_DELETE_USER = "DELETE FROM users WHERE id = ?";
    private final String SQL_UPDATE_USER = "UPDATE users " +
                                            "SET `name` = ?, email = ?, country = ? " +
                                            "WHERE id = ?";


    @Override
    public void insertUser(User user) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_INSERT_USER);
        prepareStatement.setString(1,user.getName());
        prepareStatement.setString(2,user.getEmail());
        prepareStatement.setString(3,user.getCountry());

        prepareStatement.executeUpdate();

    }

    @Override
    public User selectUser(int id) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_SELECT_USER);

        prepareStatement.setInt(1,id);

        var resultSet = prepareStatement.executeQuery();
        if(resultSet.next())
            return new User(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("country"));

        return null;
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_SELECT_ALL_USER);

        var resultSet = prepareStatement.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");

            userList.add(new User(id,name,email,country));
        }

        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_DELETE_USER);

        prepareStatement.setInt(1,id);
        var result = prepareStatement.executeUpdate();

        if(result > 0)
            return true;
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        var prepareStatement = baseRepository.getConnection().prepareStatement(SQL_UPDATE_USER);
        prepareStatement.setString(1,user.getName());
        prepareStatement.setString(2,user.getEmail());
        prepareStatement.setString(3,user.getCountry());
        prepareStatement.setInt(4,user.getId());

        var result = prepareStatement.executeUpdate();
        if(result > 0)
            return true;

        return false;
    }
}
