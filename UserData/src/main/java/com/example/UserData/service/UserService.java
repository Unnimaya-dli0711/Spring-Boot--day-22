package com.example.UserData.service;

import com.example.UserData.model.User;
import com.example.UserData.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void addUser(User user){
        userRepository.save(user);
    }
    public User findUser(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public void updateUserEmail(long id,String newEmail){
        userRepository.updateUserEmailById(id,newEmail);
    }
}
