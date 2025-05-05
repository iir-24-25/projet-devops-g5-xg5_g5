package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.Admin;
import com.esport.tournamentapp.model.User;
import com.esport.tournamentapp.repository.AdminRepository;
import com.esport.tournamentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "Username already exists";
        }
        userRepository.save(user);
        return "Signup successful";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return "Logged in as admin";
        }

        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return "Logged in successfully";
        }

        return "Invalid credentials";
    }
}
