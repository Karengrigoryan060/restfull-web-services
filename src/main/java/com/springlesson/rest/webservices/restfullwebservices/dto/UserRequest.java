package com.springlesson.rest.webservices.restfullwebservices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private Long id;

    @Size(min = 4)
    @NotNull
    @Email
    private String username;

    @NotNull
    @Size(min = 4)
    private String password;

    private Date birthday;

    private String avatarUrl;

    public UserRequest(String username, String password, Date birthday, String avatarUrl) {
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.avatarUrl = avatarUrl;
    }

    public UserRequest(Long id, String username, Date birthday, String avatarUrl) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.avatarUrl = avatarUrl;
    }
}
