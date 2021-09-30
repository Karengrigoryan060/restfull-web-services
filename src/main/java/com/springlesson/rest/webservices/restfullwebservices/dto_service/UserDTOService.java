package com.springlesson.rest.webservices.restfullwebservices.dto_service;

import com.springlesson.rest.webservices.restfullwebservices.dto.BookResponse;
import com.springlesson.rest.webservices.restfullwebservices.dto.UserRequest;
import com.springlesson.rest.webservices.restfullwebservices.dto.UserResponse;
import com.springlesson.rest.webservices.restfullwebservices.entity.User;
import com.springlesson.rest.webservices.restfullwebservices.interfaces.DTOService;
import com.springlesson.rest.webservices.restfullwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDTOService implements DTOService<UserRequest, UserResponse> {

    @Autowired
    private UserService userService;

    public UserResponse save(UserRequest userRequest) {
        User user = userService.save(userRequestToUser(userRequest));
        return userToUserResponse(user);
    }

    public UserResponse getById(Long id) {
        User user = userService.getById(id);
        return userToUserResponse(user);
    }

    public UserResponse getByUsername(String username) {
        User user = userService.getByUsername(username);
        return userToUserResponse(user);
    }

    public List<UserResponse> getAll() {
        return userService.getAll().stream().map(UserDTOService::userToUserResponse).collect(Collectors.toList());
    }

    public void delete(UserRequest userRequest) {
        userService.delete(userRequestToUser(userRequest));
    }

    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    public List<BookResponse> getBooksByUserId(Long id) {
        return userService.getById(id).getFavoriteBooks().stream()
                .map(BookDTOService::bookToBookResponse).collect(Collectors.toList());
    }

    public static User userRequestToUser(UserRequest userRequest) {
        return new User(userRequest.getUsername(), userRequest.getPassword(), userRequest.getBirthday(), userRequest.getAvatarUrl());
    }

    public static UserResponse userToUserResponse(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getBirthday(), user.getAvatarUrl());
    }
}