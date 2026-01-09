package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.AtmService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AtmController {

    private final AtmService service;

    public AtmController(AtmService service) {
        this.service = service;
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("balance", user.getBalance());
        return "dashboard";
    }


    @GetMapping("/generatePin")
    public String generatePin(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        int newPin = service.generatePin(user);
        model.addAttribute("message", "New PIN: " + newPin);
        return "dashboard";
    }

    @PostMapping("/deposit")
    public String deposit(
            @RequestParam double amount,
            @RequestParam int pin,
            HttpSession session,
            Model model) {

        User user = (User) session.getAttribute("user");

        String message = service.deposit(user, amount, pin);

        model.addAttribute("message", message);
        model.addAttribute("balance", user.getBalance());

        return "dashboard";
    }


    @PostMapping("/withdraw")
    public String withdraw(
            @RequestParam double amount,
            @RequestParam int pin,
            HttpSession session,
            Model model) {

        User user = (User) session.getAttribute("user");

        String message = service.withdraw(user, amount, pin);

        model.addAttribute("message", message);
        model.addAttribute("balance", user.getBalance());

        return "dashboard";
    }

    @GetMapping("/miniStatement")
    public String miniStatement(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        model.addAttribute("message", service.miniStatement(user));
        model.addAttribute("balance", user.getBalance());

        return "dashboard";
    }

}
