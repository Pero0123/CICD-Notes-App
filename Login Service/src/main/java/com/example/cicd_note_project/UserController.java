package com.example.cicd_note_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/update/{userId}")
    public String updatedUser(@PathVariable long userId, @RequestBody User user)
    {
        User updatedUser = userRepo.findById(userId).get();
        updatedUser.setUserId(user.getUserId());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setUsername(user.getUsername());
        userRepo.save(updatedUser);
        return "Updated";
    }

    @DeleteMapping("delete/{userId}")
    public String deleteUser(@PathVariable long userId)
    {
        User deleteUser = userRepo.findById(userId).get();
        userRepo.delete(deleteUser);
        return "Delete user with the id:" + userId;
    }
}
