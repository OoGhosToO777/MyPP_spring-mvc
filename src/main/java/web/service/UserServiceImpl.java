package web.service;

import model.User;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Override
    public User show(int id) {
        return userDAO.showUser(id);
    }

    @Override
    public void save(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        userDAO.updateUser(id, updatedUser);
    }

    @Override
    public void delete(int id) {
        userDAO.deleteUser(id);
    }
}
