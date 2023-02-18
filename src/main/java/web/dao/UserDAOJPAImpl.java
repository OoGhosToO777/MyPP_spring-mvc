package web.dao;

import model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class UserDAOJPAImpl implements UserDAO {

    private static final Logger log = Logger.getLogger("UserDAOJPAImpl");

    static {
        log.setLevel(Level.INFO);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        log.info("log_JPA_index321");
        return entityManager.createQuery("SELECT u FROM User u WHERE u.id>0", User.class).getResultList();
    }

    @Override
    public User showUser(int id) {
        log.info("log_JPA_show111");
        return (User) entityManager.createQuery("SELECT u FROM User u WHERE u.id=?1").setParameter(1, id).getSingleResult();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
        log.info("log_JPA_save");
    }

    @Override
    @Transactional
    public void updateUser(int id, User updatedUser) {
        entityManager.createQuery("UPDATE User u SET u.firstName=?1, u.lastName=?2, u.email=?3 WHERE u.id=?4")
                .setParameter(4, id)
                .setParameter(1, updatedUser.getFirstName())
                .setParameter(2, updatedUser.getLastName())
                .setParameter(3, updatedUser.getEmail())
                .executeUpdate();
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        entityManager.remove(showUser(id));
        log.info("log_JPA_delete");
    }
}
