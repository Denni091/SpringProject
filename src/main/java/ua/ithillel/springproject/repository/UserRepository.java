package ua.ithillel.springproject.repository;

import org.springframework.stereotype.Repository;
import ua.ithillel.springproject.entity.User;

import java.util.List;

@Repository
public class UserRepository {
    public List<User> getAll() {
        return List.of(
                new User("Den", "TI", 18),
                new User("Bob","AM",28));
    }
}
