package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.User;
import com.esport.tournamentapp.repository.TeamRepository;
import com.esport.tournamentapp.repository.UserRepository;
import com.esport.tournamentapp.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserAuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository; // ADD THIS

    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("user", new User());
        return "SignUp";
    }

    @PostMapping("/signup")
    public String processSignup(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/signin";
    }

    @GetMapping("/signin")
    public String signInForm() {
        return "SignIn";
    }

    @PostMapping("/signin")
    public String processSignin(@RequestParam String email,
                                @RequestParam String password,
                                Model model) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/index";
        }
        model.addAttribute("error", "Email ou mot de passe incorrect");
        return "SignIn";
    }

    @GetMapping("/index")
    public String userHome(Model model) {
        model.addAttribute("teams", teamRepository.findAll());
        model.addAttribute("players", playerRepository.findAll());
        model.addAttribute("games", playerRepository.findAll());
        return "user/user-home";
    }
}
