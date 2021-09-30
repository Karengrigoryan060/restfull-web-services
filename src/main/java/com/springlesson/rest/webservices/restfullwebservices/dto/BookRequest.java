package com.springlesson.rest.webservices.restfullwebservices.dto;

import com.springlesson.rest.webservices.restfullwebservices.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookRequest {

    private String name;

    private String author;

    private String content;

    private List<User> user;
}