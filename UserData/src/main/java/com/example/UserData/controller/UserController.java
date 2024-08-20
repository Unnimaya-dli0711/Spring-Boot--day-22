package com.example.UserData.controller;

import com.example.UserData.model.User;
import com.example.UserData.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void addUser(@RequestBody User user)
    {
        userService.addUser(user);
    }
    @GetMapping ("/{id}")
    public User findById(@PathVariable long id){
        return userService.findUser(id);
    }
}
