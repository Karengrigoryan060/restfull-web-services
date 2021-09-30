package com.springlesson.rest.webservices.restfullwebservices.controller;

import com.springlesson.rest.webservices.restfullwebservices.configuration.WebSecurityConfig;
import com.springlesson.rest.webservices.restfullwebservices.dto.BookResponse;
import com.springlesson.rest.webservices.restfullwebservices.dto.UserResponse;
import com.springlesson.rest.webservices.restfullwebservices.dto.UserRequest;
import com.springlesson.rest.webservices.restfullwebservices.dto_service.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDTOService userDTOService;

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    @PostMapping("/registration")
    public UserResponse registration(@Valid @RequestBody UserRequest userRequest) {
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

    @GetMapping("/users/{id}/books")
    public List<BookResponse> getAllBooks(@PathVariable("id") Long id) {
        return userDTOService.getBooksByUserId(id);
    }
}
