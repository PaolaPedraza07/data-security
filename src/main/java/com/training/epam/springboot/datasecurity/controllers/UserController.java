package com.training.epam.springboot.datasecurity.controllers;

import com.training.epam.springboot.datasecurity.models.UserApp;
import com.training.epam.springboot.datasecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("home")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("create")
    public UserApp createUser(@RequestBody UserApp user){
        return userService.createUser(user);
    }

    @GetMapping("read/{userId}")
    public UserApp readUserById(@PathVariable Long userId){
        return userService.readUserById(userId);
    }

    @PutMapping("update")
    public UserApp updateUser(@RequestBody UserApp user){
        return userService.updateUser(user);
    }

    @DeleteMapping("delete/{userId}")
    public String deleteUserById(@PathVariable Long userId){
        return userService.deleteUserById(userId);
    }
}
