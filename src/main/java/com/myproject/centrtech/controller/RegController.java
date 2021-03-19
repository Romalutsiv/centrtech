package com.myproject.centrtech.controller;


import java.util.Collections;

import com.myproject.centrtech.enums.UserRole;
import com.myproject.centrtech.model.User;
import com.myproject.centrtech.repo.UserRepo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reg")
public class RegController {
    private final UserRepo userRepo;
    RegController(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @GetMapping
    public String registration(){
        return "reg";
    }

    @PostMapping
    public String add(User user){
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if(userFromDb != null){
            System.out.println("існує");
        } else{
            user.setActive(true);
            user.setRoles(Collections.singleton(UserRole.USER));
            userRepo.save(user);
        }

        return "redirect:/login";
    }
    
}
