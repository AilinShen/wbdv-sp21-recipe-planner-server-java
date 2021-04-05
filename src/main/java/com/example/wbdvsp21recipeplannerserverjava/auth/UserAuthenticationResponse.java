package com.example.wbdvsp21recipeplannerserverjava.auth;

public class UserAuthenticationResponse {

    private final String jwt;

    public UserAuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
