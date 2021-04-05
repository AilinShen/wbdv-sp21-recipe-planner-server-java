package com.example.wbdvsp21recipeplannerserverjava.controllers;

import com.example.wbdvsp21recipeplannerserverjava.models.User;
import com.example.wbdvsp21recipeplannerserverjava.services.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloControllers {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    ApplicationUserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "Successfully logged in";
    }


    @PostMapping(value = "/register")
    public String processRegister(@RequestBody User requestUser) {

        System.out.println(requestUser.getUsername());

        String encodedPassword = bCryptPasswordEncoder.encode(requestUser.getPassword());
        User user = new User(requestUser.getUsername(), encodedPassword);

        userService.createUser(user);
        return requestUser.getUsername();
    }

    @GetMapping(value = "/register")
    public String register(){
        return "register:";
    }
}
