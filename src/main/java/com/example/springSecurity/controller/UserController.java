package com.example.springSecurity.controller;

import com.example.springSecurity.model.User;
import com.example.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/findAll")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/addUser")
    public User addNewUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
