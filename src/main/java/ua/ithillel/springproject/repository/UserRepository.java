package ua.ithillel.springproject.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ua.ithillel.springproject.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        users.add(new User(0, "Den", "TI", "den@gmail.com", "0975672897", 26));
        users.add(new User(1, "Bob", "AM", "bob@gmail.com", "0992756543", 21));
    }

    public List<User> getAll() {
        return users;
    }

    public User getById(Integer id) {
        return users.get(id);
    }

    public List<User> getEmailAndPhone(String email, String phone) {
        return users.stream().
                filter(user -> email.equals(user.getEmail()) && phone.equals(user.getPhone())).
                collect(Collectors.toList());
    }

    public List<User> getUserByFilter(String name, String surname, String email) {
        return users.stream().filter(user -> user.getName().equals(name) || user.getSurname().equals(surname)
                || user.getEmail().equals(email)).collect(Collectors.toList());
    }

    public User save(User user) {
        users.add(user);
        user.setId(users.size());
        return user;
    }

    public User update(Integer id, User user) {
        User oldUser = users.get(id);
        oldUser.setName(user.getName());
        oldUser.setSurname(user.getSurname());
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhone(user.getPhone());
        return users.get(id);
    }

    public Integer delete(int id) {
        users.remove(id);
        return id;
    }
}
