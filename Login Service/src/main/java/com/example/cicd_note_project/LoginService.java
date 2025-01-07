package com.example.cicd_note_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepo userRepo;

    public Optional<User> getUserByUsername(@PathVariable String username)
    {
        return userRepo.findByUsername(username);
    }
}
