package com.springlesson.rest.webservices.restfullwebservices.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private Date birthday;

    private String avatarUrl;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Book> favoriteBooks;

    public User(String username, String password, Date birthday, String avatarUrl) {
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.avatarUrl = avatarUrl;
    }
}
