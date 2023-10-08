package com.example.reactsneakersfinalproject.services;

import com.example.reactsneakersfinalproject.models.Role;
import com.example.reactsneakersfinalproject.models.User;
import com.example.reactsneakersfinalproject.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Data
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        Role role1 = Role.USER;
        User user1 = new User();
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
        user1.setPassword(user.getPassword());
        user1.setRole(role1);

        return userRepository.save(user1);
    }

    public User getUserByLoginAndPass(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        return userRepository.getUserByLoginAndPass(email, password);

    }

    public User getUserByPass(String email) {
        return userRepository.getUserByPass(email);
    }

    @Transactional
    public void updateUser(int id,  String name, String email,
                           String phone, String password) {

        userRepository.updateUser(id, name, email, phone, password);

    }

}
