package com.example.springSecurity.repository;

import com.example.springSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
