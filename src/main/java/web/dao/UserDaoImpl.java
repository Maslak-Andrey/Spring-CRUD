package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public UserDaoImpl() {
    }

    @Override
    public List<User> userList() {
        List<User> list = null;

        try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
            list = (List<User>) session.createQuery("From User").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User show(int id) {
        User user = null;
        try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
            user = session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void save(User user) {
        try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, User updatedUser) {
        try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
            session.beginTransaction();
            session.update(updatedUser);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
            session.beginTransaction();
            session.remove(session.get(User.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
