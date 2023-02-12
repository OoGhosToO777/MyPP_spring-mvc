package web.dao;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Component
@Slf4j
public class UserDAOHIbernateImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    public UserDAOHIbernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<User> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public User showUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("show");
        return session.get(User.class, id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        System.out.println("save");
    }

    @Override
    @Transactional
    public void updateUser(int id, User updatedUser) {
        Session session = sessionFactory.getCurrentSession();
//        session.createQuery("UPDATE User u SET u=:u WHERE u.id=:id").setParameter("u", updatedUser).setParameter("id", id);

        User personToBeUpdated = session.get(User.class, id);

        personToBeUpdated.setFirstName(updatedUser.getFirstName());
        personToBeUpdated.setLastName(updatedUser.getLastName());
        personToBeUpdated.setEmail(updatedUser.getEmail());

        System.out.println("update");
        log.debug("logUpdate");

    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("DELETE User u WHERE u.id=:id").setParameter("id",id);
        //TODO 111
        System.out.println("DELETE!???");
    }
}
