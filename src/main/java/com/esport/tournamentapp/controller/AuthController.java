package com.esport.tournamentapp.controller;

// import com.esport.tournamentapp.model.Admin;
// import com.esport.tournamentapp.repository.AdminRepository;
// import jakarta.servlet.http.HttpSession;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    // @Autowired
    // private AdminRepository adminRepository;

   /* @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // loads login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            session.setAttribute("admin", admin);
            return "redirect:/admin/dashboard"; // or whatever your main admin page is
        }

        // Login failed
        return "redirect:/login?error";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    } */
}
