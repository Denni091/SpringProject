package ua.ithillel.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.springproject.entity.User;
import ua.ithillel.springproject.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }


    public User getById(Integer id) {
        return userRepository.getById(id);
    }

    public List<User> getEmailAndPhone(String email, String phone) {
        return userRepository.getEmailAndPhone(email, phone);
    }

    public List<User> getUserByFilter(String name, String surname, String email) {
        return userRepository.getUserByFilter(name, surname, email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Integer id, User user) {
        return userRepository.update(id, user);
    }

    public Integer delete(Integer id) {
        return userRepository.delete(id);
    }
}
