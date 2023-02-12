package web.dao;

import model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDAO {

    List<User> index();

    User showUser(int id);

    void saveUser(User user);

    void updateUser(int id, User updatedUser);

    void deleteUser(int id);
}
