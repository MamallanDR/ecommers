package com.example.ecommers.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequestDTO {

    private String username;
    private String password;
    private String emailId;
}
