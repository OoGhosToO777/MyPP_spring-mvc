package web.dao;

import model.User;

import java.util.List;

public interface UserDAO {

    List<User> index();

    User showUser(int id);

    void saveUser(User user);

    void updateUser(int id, User updatedUser);

    void deleteUser(int id);
}
