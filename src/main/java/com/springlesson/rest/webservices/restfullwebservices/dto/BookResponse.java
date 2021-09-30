package com.springlesson.rest.webservices.restfullwebservices.dto;

import com.springlesson.rest.webservices.restfullwebservices.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    private String content;

    private List<User> user;
}