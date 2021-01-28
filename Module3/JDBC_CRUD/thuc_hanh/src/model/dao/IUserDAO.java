package model.dao;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void insertUser(User user) throws SQLException;

    User selectUser(int id) throws SQLException;

    List<User> selectAllUsers() throws SQLException;

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    List<User> searchByCountry(String country) throws SQLException;
}
