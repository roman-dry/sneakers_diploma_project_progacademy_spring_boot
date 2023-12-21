package com.example.reactsneakersfinalproject.services;

import com.example.reactsneakersfinalproject.dto.UserDTO;
import com.example.reactsneakersfinalproject.models.Role;
import com.example.reactsneakersfinalproject.models.User;
import com.example.reactsneakersfinalproject.repositories.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO getUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow();
        UserDTO userDTO = new UserDTO();
        userDTO = userDTO.createEntity(user);
        return userDTO;
    }

    @Transactional
    public void updateUser(Integer id,
                           String name,
                           String phone,
                           String password) {


        userRepository.updateUser(id, name, phone, password);
    }
}
