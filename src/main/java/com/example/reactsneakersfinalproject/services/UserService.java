package com.example.reactsneakersfinalproject.services;

import com.example.reactsneakersfinalproject.models.User;
import com.example.reactsneakersfinalproject.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Data
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User getUserByLoginAndPass(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        return userRepository.getUserByLoginAndPass(email, password);
    }

    public User getUserByPass(String email) {
        return userRepository.getUserByPass(email);
    }


}
