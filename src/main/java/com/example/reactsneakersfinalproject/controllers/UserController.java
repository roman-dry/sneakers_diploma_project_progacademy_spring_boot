package com.example.reactsneakersfinalproject.controllers;

import com.example.reactsneakersfinalproject.models.User;
import com.example.reactsneakersfinalproject.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/")
public class UserController {
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/login")
    public User getUserByLoginAndPass(@RequestBody User user) {
        return userService.getUserByLoginAndPass(user);
    }

    @GetMapping("/login")
    public User getUserByPass(@RequestParam String email) {
        return userService.getUserByPass(email);
    }

    @PatchMapping("/user")
    public void updateUser(@RequestParam int id,
                           @RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String phone,
                           @RequestParam String password) {
        userService.updateUser(id, name, email, phone, password);
    }
}
