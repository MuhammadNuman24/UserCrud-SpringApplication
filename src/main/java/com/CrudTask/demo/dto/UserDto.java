package com.CrudTask.demo.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class UserDto {

    private Long userId;
    @NotNull
    private String userIdNumber;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String role;
    private String description;

}
