package com.example.wbdvsp21recipeplannerserverjava.auth;

public class UserAuthenticationResponse {

    private int status;
    private String authorization;
    private String userId;
    private String message;
    private String username;

    public UserAuthenticationResponse(int status, String authorization, String userId, String name) {
        this.status = status;
        this.authorization = authorization;
        this.userId = userId;
        this.username = name;
    }

    public UserAuthenticationResponse(int status, String authorization, String userId, String name, String message) {
        this.status = status;
        this.authorization = authorization;
        this.userId = userId;
        this.username = name;
        this.message = message;
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
