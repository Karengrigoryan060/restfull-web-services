package com.springlesson.rest.webservices.restfullwebservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {

        com.springlesson.rest.webservices.restfullwebservices.entity.User byUsername =
                userService.getByUsername(username);
        return new User(byUsername.getUsername(), byUsername.getPassword(), new ArrayList<>());
    }
}