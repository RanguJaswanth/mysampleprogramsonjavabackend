package com.example.loginapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.loginapp.entity.User;
import com.example.loginapp.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.register(user);
        model.addAttribute("message", "User registered successfully!");
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, 
                        @RequestParam String password, 
                        Model model) {

        boolean isValid = userService.validateUser(email, password);

        if (isValid) {
            model.addAttribute("username", email);
            return "welcome";
        } else {
            model.addAttribute("error", "Invalid email or password!");
            return "login";
        }
    }
}
