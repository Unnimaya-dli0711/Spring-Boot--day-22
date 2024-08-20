package com.example.UserData.service;

import com.example.UserData.model.User;
import com.example.UserData.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
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
    public void deleteById(Long id){
        logger.info("Attempting to delete user with ID: " + id);
        userRepository.deleteById(id);
        logger.info("User with ID: " + id + " deleted successfully.");
    }
    public void addUserBatch(List<User> users){userRepository.saveAll(users);}
    public void updateUserEmails(List<User>users){
        for(User user:users){
            userRepository.findById(user.getId()).ifPresent(existingUser->{
                existingUser.setEmail(user.getEmail());
                userRepository.save(existingUser);

            });
        }
    }

    public List<User> findAll(){
       return userRepository.findAll();
    }
}
