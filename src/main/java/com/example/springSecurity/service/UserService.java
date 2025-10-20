package com.example.springSecurity.service;

import com.example.springSecurity.model.User;
import com.example.springSecurity.repository.UserRepo;
import com.example.springSecurity.util.UserNameAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User addUser(User user) throws UserNameAlreadyExists {
        User u = userRepo.findByName(user.getName());
        if(u!=null){
            throw new UserNameAlreadyExists();
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    public List<User> findAllUsers(){
        return userRepo.findAll();
    }
}
