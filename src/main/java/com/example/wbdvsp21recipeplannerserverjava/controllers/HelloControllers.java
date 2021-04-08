package com.example.wbdvsp21recipeplannerserverjava.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class HelloControllers {


    @GetMapping("/")
    public String welcome(){return "Welcome"; }

    @RequestMapping("/hello")
    public String hello() {
        return "Successfully logged in";
    }


}
