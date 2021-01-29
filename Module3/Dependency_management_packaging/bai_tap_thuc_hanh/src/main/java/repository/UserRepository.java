package repository;

import bean.User;

import java.util.List;

public interface UserRepository {

    void save(User user);
    List<User> findAll();
    User findById(Integer id);
    User findByName(String name);
    void deleteById(Integer id);
    User getUserById(Integer id);
}
