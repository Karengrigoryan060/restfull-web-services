package com.springlesson.rest.webservices.restfullwebservices.controller;

import com.springlesson.rest.webservices.restfullwebservices.configuration.WebSecurityConfig;
import com.springlesson.rest.webservices.restfullwebservices.dto.UserDTO;
import com.springlesson.rest.webservices.restfullwebservices.dto.UserRequest;
import com.springlesson.rest.webservices.restfullwebservices.dto_service.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserDTOService userDTOService;

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    @PostMapping("/registration")
    public UserDTO registration(@Valid @RequestBody UserRequest userRequest) {
        String encodedPassword = webSecurityConfig.passwordEncoder().encode(userRequest.getPassword());
        userRequest.setPassword(encodedPassword);
        return userDTOService.save(userRequest);
    }

    @GetMapping("/users")
    public void getAllUsers() {
        userDTOService.getAll();
    }

    @GetMapping("/users/{id}")
    public void getUserById(@PathVariable Long id) {
        userDTOService.getById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userDTOService.deleteById(id);
    }

}
