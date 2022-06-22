package com.training.epam.springboot.datasecurity.services;

import com.training.epam.springboot.datasecurity.configuration.security.UserHelper;
import com.training.epam.springboot.datasecurity.models.UserApp;
import com.training.epam.springboot.datasecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersAppService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserHelper loadUserByUsername(String email) throws UsernameNotFoundException {
        UserApp userApp = null;
        try{
            userApp = userRepository.findByEmail(email);
            UserHelper userDetail  = new UserHelper(userApp);
            return userDetail;
        }catch (Exception e){
            e.printStackTrace();
            throw new UsernameNotFoundException("User " + email + " was not found in the database");
        }
    }
}
