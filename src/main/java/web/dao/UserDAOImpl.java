package web.dao;

import model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.config.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    private final Util util;
    public UserDAOImpl(Util util) {
        this.util = util;
    }

    @Transactional(readOnly = true)
    public List<User> index() {
        List<User> list = new ArrayList<>();
        try (Statement statement = util.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));

                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Transactional(readOnly = true)
    public User showUser(int id) {
        String request = "SELECT * FROM users WHERE id=?";
        User user;
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement(request)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    @Transactional
    public void saveUser(User user) {
        String request = "INSERT INTO users(first_name, last_name, email) VALUES(?, ?, ?);";
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement(request)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void updateUser(int id, User user) {
        String request = "UPDATE Users SET first_name=?, last_name=?, email=? WHERE id=?";
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement(request)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(int id) {
        String request = "DELETE FROM users WHERE id=?";
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement(request)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
