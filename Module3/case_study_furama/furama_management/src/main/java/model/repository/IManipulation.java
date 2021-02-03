package model.repository;

import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IManipulation <T>{
    void add(T t) throws SQLException;

    T findById(int id) throws SQLException;

    List<T> findAll() throws SQLException;

    boolean deleteById(int id) throws SQLException;

    boolean update(T t) throws SQLException;

    List<T> searchByName(String name) throws SQLException;

}
