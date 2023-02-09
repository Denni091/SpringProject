package ua.ithillel.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.springproject.controller.dto.IntegerDto;
import ua.ithillel.springproject.controller.dto.UserDto;
import ua.ithillel.springproject.controller.mapper.UserMapper;
import ua.ithillel.springproject.entity.User;
import ua.ithillel.springproject.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<>(userService.getAll().
                stream().
                map(userMapper::toDto).
                collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        User byId = userService.getById(id);
        return ResponseEntity.ok(userMapper.toDto(byId));
    }

    @GetMapping("/{email}/{phone}")
    public ResponseEntity<List<UserDto>> getEmailAndPhone(@PathVariable String email, @PathVariable String phone) {
        return new ResponseEntity<>(userService.getEmailAndPhone(email, phone).
                stream().
                map(userMapper::toDto).
                collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @GetMapping("/filter")
    public List<User> getUserByFilter(
            @RequestParam String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String email) {

        return userService.getUserByFilter(name, surname, email);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userMapper.toDto(userService.save(userMapper.toEntity(userDto))),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(
                userMapper.toDto(userService.update(userMapper.toEntity(userDto))),
                HttpStatus.ACCEPTED
        );
    }

    @PutMapping("/{email}/{id}")
    public ResponseEntity<IntegerDto> updateEmailById(@PathVariable String email, @PathVariable Integer id) {
        return new ResponseEntity<>(new IntegerDto(userService.updateEmailById(email, id)),
                HttpStatus.OK
        );
    }

    @DeleteMapping
    public Integer delete(@RequestParam Integer id) {
        return userService.delete(id);
    }
}
