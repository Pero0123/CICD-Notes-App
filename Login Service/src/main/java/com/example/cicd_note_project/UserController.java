package com.example.cicd_note_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String getPage(){
        return "welcome";
    }

    @GetMapping("/user")
    public List<User> getUser(){
        return userRepo.findAll();
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user)
    {
        userRepo.save(user);
        return "saved user";
    }

    @PutMapping("/update/{userID}")
    public String updatedUser(@PathVariable long userID, @RequestBody User user)
    {
        User updatedUser = userRepo.findById(userID).get();
        updatedUser.setUserId(user.getUserId());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setUsername(user.getUsername());
        userRepo.save(updatedUser);
        return("Updated");
    }
}
