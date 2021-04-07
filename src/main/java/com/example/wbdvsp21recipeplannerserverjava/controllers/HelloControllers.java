package com.example.wbdvsp21recipeplannerserverjava.controllers;

import com.example.wbdvsp21recipeplannerserverjava.models.User;
import com.example.wbdvsp21recipeplannerserverjava.services.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloControllers {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    ApplicationUserService userService;

    @RequestMapping("/hello")
    public String hello() {
        return "Successfully logged in";
    }

    @RequestMapping("/shopper")
    public String shopper() {
        return "SHOPPER: Successfully logged in";
    }


    @RequestMapping("/creator")
    public String creator() {
        return "CREATOR: Successfully logged in";
    }


    @PostMapping(value = "/register")
    public String processRegister(@RequestBody User requestUser) {

        String encodedPassword = bCryptPasswordEncoder.encode(requestUser.getPassword());
        User user = new User(requestUser.getUsername(), encodedPassword, requestUser.getRole());

        userService.createUser(user);
        return requestUser.getUsername();
    }

    @GetMapping(value = "/register")
    public String register() {
        return "register:";
    }
}
