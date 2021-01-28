package model.service;

import model.bean.User;
import model.dao.IUserDAO;
import model.dao.UserDao;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService{
    private IUserDAO userDao = new UserDao();

    @Override
    public void insertUser(User user) throws SQLException {
        userDao.insertUser(user);
    }

    @Override
    public User selectUser(int id) throws SQLException {
        return userDao.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        return userDao.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userDao.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userDao.updateUser(user);
    }

    @Override
    public List<User> searchByCountry(String country) throws SQLException {
        return userDao.searchByCountry(country);
    }
}
