package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AtmService {

    private final UserRepository repo;

    public AtmService(UserRepository repo) {
        this.repo = repo;
    }

    public int generatePin(User user) {
        int newPin = new Random().nextInt(9000) + 1000;
        user.setPin(newPin);
        repo.save(user);
        return newPin;
    }

    public String deposit(User user, double amount, int pin) {

        if (user.getPin() != pin) {
            return "Invalid PIN";
        }

        user.setBalance(user.getBalance() + amount);
        user.setLastAction("DEPOSIT");
        user.setLastAmount(amount);

        repo.save(user);
        return "Deposit successful";
    }


    public String withdraw(User user, double amount, int pin) {

        if (user.getPin() != pin) {
            return "Invalid PIN";
        }

        if (user.getBalance() < amount) {
            return "Insufficient balance";
        }

        user.setBalance(user.getBalance() - amount);
        user.setLastAction("WITHDRAW");
        user.setLastAmount(amount);

        repo.save(user);
        return "Withdraw successful";
    }
    public String miniStatement(User user) {
        if (user.getLastAction() == null) {
            return "No transactions yet";
        }

        return "Last Action: " + user.getLastAction() +
               ", Amount: " + user.getLastAmount();
    }


    public double getBalance(User user) {
        return user.getBalance();
    }
}
