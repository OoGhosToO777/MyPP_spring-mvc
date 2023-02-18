package web.dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return session.get(User.class, id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(int id, User updatedUser) {
        Session session = sessionFactory.getCurrentSession();
        User personToBeUpdated = session.get(User.class, id);

        personToBeUpdated.setFirstName(updatedUser.getFirstName());
        personToBeUpdated.setLastName(updatedUser.getLastName());
        personToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("DELETE User u WHERE u.id=:id").setParameter("id",id);
    }
}
