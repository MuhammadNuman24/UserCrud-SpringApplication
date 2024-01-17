package com.CrudTask.demo.services;


import com.CrudTask.demo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Long userId);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUser();

    void deleteUser(Long userID);

}