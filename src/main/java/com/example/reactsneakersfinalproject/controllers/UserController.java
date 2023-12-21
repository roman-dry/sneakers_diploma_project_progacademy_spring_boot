package com.example.reactsneakersfinalproject.controllers;

import com.example.reactsneakersfinalproject.dto.UserDTO;
import com.example.reactsneakersfinalproject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    public final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PatchMapping ("/edit")
    public void updateUser(@RequestParam Integer id,
                           @RequestParam String name,
                           @RequestParam String phone,
                           @RequestParam String password) {
        String newPass = passwordEncoder.encode(password);
        userService.updateUser(id, name, phone, newPass);
    }
}
