package com.example.springsecurity.service;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.enums.UserStatus;
import com.example.springsecurity.exception.UserAlreadyExistException;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void saveUser(Map<String, String> registerUser) throws UserAlreadyExistException {
        Optional<User> optionalUser = userRepository.findByUsername(registerUser.get("username"));
        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistException("User already exist!Please choose another user name.");
        }
        User user = new User();
        user.setUsername(registerUser.get("username"));
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        user.setRoles("DEV,PM");
        user.setStatus(UserStatus.ACTIVE);
        userRepository.save(user);

    }
}
