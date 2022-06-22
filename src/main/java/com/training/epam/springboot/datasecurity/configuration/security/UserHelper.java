package com.training.epam.springboot.datasecurity.configuration.security;

import com.training.epam.springboot.datasecurity.models.UserApp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserHelper extends User {


    private static final long serialVersionUID = 1L;
    public UserHelper(UserApp user) {
        super(user.getEmail(), user.getNombre(), user.getAuthorities());
    }
}
