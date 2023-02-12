package web.dao;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Slf4j
public class UserDAOJPAImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        System.out.println("JPA_index");
        return entityManager.createQuery("SELECT u FROM User u WHERE u.id>0", User.class).getResultList();
    }

    @Override
    public User showUser(int id) {
        System.out.println("JPA_show111");
        log.info("logINFO");
        log.debug("logDEBUG");
        log.error("logERROR");

        log.trace("Trace");
        log.warn("warn");
        return (User) entityManager.createQuery("SELECT u FROM User u WHERE u.id=?1").setParameter(1, id).getSingleResult();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
        System.out.println("JPA_save");
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
    public void deleteUser(int id) {
        entityManager.createQuery("DELETE from User u WHERE u.id=?1").setParameter(1, id).executeUpdate();
        System.out.println("JPA_delete");
    }
}
