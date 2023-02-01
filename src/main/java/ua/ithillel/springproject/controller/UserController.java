package ua.ithillel.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.ithillel.springproject.entity.User;
import ua.ithillel.springproject.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public List<User> getAll() {
        return userService.getAll();
    }
}
