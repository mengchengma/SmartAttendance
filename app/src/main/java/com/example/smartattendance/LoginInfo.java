package com.example.smartattendance;

public class LoginInfo {
    private String email;
    private String password;

    // Empty constructor (required for Firebase)
    public LoginInfo() {
    }

    // Constructor with parameters
    public LoginInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

