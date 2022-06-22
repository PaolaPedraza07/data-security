package com.training.epam.springboot.datasecurity.services;

import com.training.epam.springboot.datasecurity.models.UserApp;
import com.training.epam.springboot.datasecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public UserApp createUser(UserApp user){
        return userRepository.save(user);
    }

    public UserApp readUserById(Long userId){
        Optional<UserApp> userResponse = userRepository.findById(userId);
        return userResponse.orElse(null);
    }

    public UserApp updateUser(UserApp user){
        return userRepository.save(user);
    }

    public String deleteUserById(Long userId){
        userRepository.deleteById(userId);
        return "The user has been deleted";
    }

}
