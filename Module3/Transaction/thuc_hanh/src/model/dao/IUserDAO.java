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

    User getUserById(int id) throws SQLException;

    void insertUserStore(User user) throws SQLException;

    void addUserTransaction(User user, int[] permision) throws SQLException;

    void insertUpdateWithoutTransaction();

    void insertUpdateUseTransaction() throws SQLException;

    List<User> selectAllUsersBySP() throws SQLException;

    boolean updateUserBySP(User user) throws SQLException;

    boolean deleteUserBySP(int id) throws SQLException;
}
