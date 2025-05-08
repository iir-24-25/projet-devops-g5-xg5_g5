package com.esport.tournamentapp.controller;

import com.esport.tournamentapp.model.User;
import com.esport.tournamentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserAuthController {

    @Autowired
    private UserRepository userRepository;


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
        User user = userRepository.findByEmail(email); // or findByEmail(email)
        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/index";
        }
        model.addAttribute("error", "Email ou mot de passe incorrect");
        return "SignIn";
    }





    @GetMapping("/index")
    public String userHome() {
            return "user/user-home";
    }
}
