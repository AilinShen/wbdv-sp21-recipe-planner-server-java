package com.example.wbdvsp21recipeplannerserverjava.controllers;

import com.example.wbdvsp21recipeplannerserverjava.models.Recipe;
import com.example.wbdvsp21recipeplannerserverjava.models.User;
import com.example.wbdvsp21recipeplannerserverjava.services.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserControllers {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    ApplicationUserService userService;

    @GetMapping("/api/users")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/shopper")
    public String shopper() {
        return "SHOPPER: Successfully logged in";
    }

    @GetMapping("/creator")
    public String creator() {
        return "CREATOR: Successfully logged in";
    }


    // {
    //    "username": "shopper",
    //    "password": "password",
    //    "role": "SHOPPER"
    //}
    @PostMapping(value = "/register")
    public Integer processRegister(@RequestBody User requestUser) {

        String encodedPassword = bCryptPasswordEncoder.encode(requestUser.getPassword());
        User user = new User(requestUser.getUsername(), encodedPassword, requestUser.getRole());

        User saveUser = userService.createUser(user);
        return saveUser.getId();
    }

}
