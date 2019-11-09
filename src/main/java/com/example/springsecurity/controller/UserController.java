package com.example.springsecurity.controller;


import com.example.springsecurity.entity.User;
import com.example.springsecurity.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAllUsers(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                                                  @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){

        userService.hashCode();
        return null;
    }

}
