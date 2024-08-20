package com.example.UserData.controller;

import com.example.UserData.model.User;
import com.example.UserData.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public User findById(@PathVariable Long id){
        return userService.findUser(id);
    }

    @PutMapping("/{id}/email")
    public void updateUserMail(@PathVariable Long id,@RequestBody String newEmail){
        userService.updateUserEmail(id,newEmail);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/addmultiple")
    public void addUserBatch(@RequestBody List<User> users)
    {
        userService.addUserBatch(users);
    }

    @PatchMapping("/update-emails")
    public void updateUserEmails(@RequestBody List<User> users){
        userService.updateUserEmails(users);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.findAll();
    }
    @GetMapping("/by-domain")
    public List<User> findByDomain(@RequestParam String domain){
        return userService.findByDomain(domain);
    }
}
