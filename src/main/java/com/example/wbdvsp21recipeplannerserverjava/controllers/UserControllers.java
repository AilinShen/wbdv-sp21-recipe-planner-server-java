package com.example.wbdvsp21recipeplannerserverjava.controllers;

import com.example.wbdvsp21recipeplannerserverjava.models.Recipe;
import com.example.wbdvsp21recipeplannerserverjava.models.User;
import com.example.wbdvsp21recipeplannerserverjava.security.ApiResponse;
import com.example.wbdvsp21recipeplannerserverjava.services.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<User> users = userService.findAllUsers();
        ArrayList<User> results = new ArrayList<>();
        for(User user: users){
            results.add(new User(user.getId(), user.getEmail(), user.getName(), user.getRole()));
        }
        return results;
    }

    @GetMapping("/api/users/{uid}")
    public User findUserById( @PathVariable("uid") Integer id){
        User user = userService.findUserById(id);
        return new User(user.getId(), user.getEmail(), user.getName(), user.getRole());
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
    public ApiResponse processRegister(@RequestBody User requestUser) {

        if (userService.findIdByEmail(requestUser.getEmail()) == null){
            String encodedPassword = bCryptPasswordEncoder.encode(requestUser.getPassword());
            User user = new User(requestUser.getEmail(), requestUser.getName(), encodedPassword, requestUser.getRole());
            User saveUser = userService.createUser(user);

            return new ApiResponse(200, "Success");
        }
        return new ApiResponse(403, "Email already exists");
    }

    @PutMapping("/api/users/{uid}")
    public User updateUser(
            @PathVariable("uid") Integer id,
            @RequestBody User newUser
    ){
        if(newUser.getPassword() != null) {
            String encodedPassword = bCryptPasswordEncoder.encode(newUser.getPassword());
            newUser.setPassword(encodedPassword);
        }
        User user = userService.updateUser(id, newUser);
        return new User(user.getId(), user.getEmail(), user.getName(), user.getRole());
    }

    @DeleteMapping("/api/users/{uid}")
    public void deleteUser(
            @PathVariable("uid") Integer id
    ){
        userService.deleteUserById(id);
    }

}
