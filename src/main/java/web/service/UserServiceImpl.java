package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoImpl;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDaoImpl userDaoImpl;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }


    @Override
    public List<User> userList() {
        return userDaoImpl.userList();
    }

    @Override
    public User show(int id) {
        return userDaoImpl.show(id);
    }

    @Override
    public void save(User user) {
        userDaoImpl.save(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        userDaoImpl.update(id, updatedUser);
    }

    @Override
    public void delete(int id) {
        userDaoImpl.delete(id);
    }
}
