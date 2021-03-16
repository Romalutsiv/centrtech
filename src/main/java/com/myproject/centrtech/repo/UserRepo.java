package com.myproject.centrtech.repo;

import com.myproject.centrtech.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
}
