package ua.ithillel.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.springproject.entity.User;
import ua.ithillel.springproject.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/{email}/{phone}")
    public List<User> getEmailAndPhone(@PathVariable String email, @PathVariable String phone) {
        return userService.getEmailAndPhone(email, phone);
    }

    @GetMapping("/filter")
    public List<User> getUserByFilter(
            @RequestParam String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String email) {

        return userService.getUserByFilter(name, surname, email);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping
    public Integer delete(@RequestParam Integer id) {
        return userService.delete(id);
    }
}
