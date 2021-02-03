package model.service;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {
    String add(T t) throws SQLException;

    T findById(int id) throws SQLException;

    List<T> findAll() throws SQLException;

    boolean deleteById(int id) throws SQLException;

    String update(T t) throws SQLException;

    List<T> searchByName(String name) throws SQLException;
}
