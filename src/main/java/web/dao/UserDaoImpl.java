package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    private static int COUNT;
    
    List<User> list;

    {
        list = new ArrayList<>();

        list.add(new User(++COUNT,"Test1", "SuTest1", "test1@mail.com"));
        list.add(new User(++COUNT,"Test2", "SuTest2", "test2@mail.com"));
        list.add(new User(++COUNT,"Test3", "SuTest3", "test3@mail.com"));
        list.add(new User(++COUNT,"Test4", "SuTest4", "test4@mail.com"));
    }

    @Override
    public List<User> userList() {
        return list;
    }

    @Override
    public User show(int id) {
        return list.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        user.setId(++COUNT);
        list.add(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    public void delete(int id) {
        list.removeIf(u -> u.getId() == id);
    }
}
