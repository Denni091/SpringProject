package ua.ithillel.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.springproject.entity.User;
import ua.ithillel.springproject.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    //    private final FakeUserRepository fakeUserRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }


    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> getEmailAndPhone(String email, String phone) {
        return userRepository.getUserByEmailAndPhone(email, phone);
    }

    public List<User> getUserByFilter(String name, String surname, String email) {
        return userRepository.getUserByNameOrSurnameOrPhone(name, surname, email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public Integer updateEmailById(String email, Integer id) {
        return userRepository.updateEmailUserById(email, id);
    }

    public Integer delete(Integer id) {
        userRepository.deleteById(id);
        return id;
    }
}
