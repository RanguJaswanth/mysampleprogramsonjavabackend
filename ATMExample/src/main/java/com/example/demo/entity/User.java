package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private int pin;
    private double balance;

    private String lastAction;
    private double lastAmount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getLastAction() {
		return lastAction;
	}
	public void setLastAction(String lastAction) {
		this.lastAction = lastAction;
	}
	public double getLastAmount() {
		return lastAmount;
	}
	public void setLastAmount(double lastAmount) {
		this.lastAmount = lastAmount;
	}
	public User(Long id, String username, int pin, double balance, String lastAction, double lastAmount) {
		super();
		this.id = id;
		this.username = username;
		this.pin = pin;
		this.balance = balance;
		this.lastAction = lastAction;
		this.lastAmount = lastAmount;
	}

    // getters and setters
    public User() {}
}
