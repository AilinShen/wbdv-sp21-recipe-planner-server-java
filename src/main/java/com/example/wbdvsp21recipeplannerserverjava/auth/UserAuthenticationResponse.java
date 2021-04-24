package com.example.wbdvsp21recipeplannerserverjava.auth;

public class UserAuthenticationResponse {

    private int status;
    private String authorization;
    private String userId;
    private String message;
    private String username;
    private String role;
    private String email;

    public UserAuthenticationResponse(int status, String authorization, String email, String userId, String name, String role) {
        this.status = status;
        this.authorization = authorization;
        this.email = email;
        this.userId = userId;
        this.username = name;
        this.role = role;
    }

    public UserAuthenticationResponse(int status, String authorization, String email, String userId, String name, String role, String message) {
        this.status = status;
        this.authorization = authorization;
        this.email = email;
        this.userId = userId;
        this.username = name;
        this.role =role;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
