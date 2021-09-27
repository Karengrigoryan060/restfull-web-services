package com.springlesson.rest.webservices.restfullwebservices.service;

import com.springlesson.rest.webservices.restfullwebservices.entity.User;
import com.springlesson.rest.webservices.restfullwebservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void remove(User user) {
        userRepository.delete(user);
    }

    @Transactional
    public void removeById(Long id) {
        User user = getById(id);
        userRepository.delete(user);
    }
}
