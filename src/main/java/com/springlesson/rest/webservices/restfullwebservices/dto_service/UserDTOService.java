package com.springlesson.rest.webservices.restfullwebservices.dto_service;

import com.springlesson.rest.webservices.restfullwebservices.dto.UserDTO;
import com.springlesson.rest.webservices.restfullwebservices.dto.UserRequest;
import com.springlesson.rest.webservices.restfullwebservices.entity.User;
import com.springlesson.rest.webservices.restfullwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDTOService {

    @Autowired
    private UserService userService;

    public UserDTO save(UserRequest userRequest) {
        User user = userService.save(userRequestToUser(userRequest));
        return userToUserDTO(user);
    }

    public UserDTO getById(Long id) {
        User user = userService.getById(id);
        return userToUserDTO(user);
    }

    public UserDTO getByUsername(String username) {
        User user = userService.getByUsername(username);
        return userToUserDTO(user);
    }

    public List<UserDTO> getAll() {
        return userService.getAll().stream().map(this::userToUserDTO).collect(Collectors.toList());
    }

    public void delete(UserDTO userDTO) {
        userService.remove(userDTOToUser(userDTO));
    }

    public void deleteById(Long id) {
        userService.removeById(id);
    }

    private User userRequestToUser(UserRequest userRequest) {
        return new User(userRequest.getUsername(), userRequest.getPassword(), userRequest.getBirthday(), userRequest.getAvatarUrl());
    }

    private User userDTOToUser(UserDTO userDTO) {
        return new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getBirthday(), userDTO.getAvatarUrl());
    }

    private UserDTO userToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getBirthday(), user.getAvatarUrl());
    }
}