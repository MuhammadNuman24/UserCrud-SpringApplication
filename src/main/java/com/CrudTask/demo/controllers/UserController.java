package com.CrudTask.demo.controllers;

import com.CrudTask.demo.dto.UserDto;
import com.CrudTask.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;
    // create a new user
    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.createUser(userDto);
        return (new ResponseEntity<>(createUserDto, HttpStatus.CREATED));
    }

    // Get All User
    @GetMapping("/users")

    public ResponseEntity<List<UserDto>> getAllUser() {
        return (ResponseEntity.ok(userService.getAllUser()));
    }

    //Get user by id
    @GetMapping(value = "/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userById = userService.getUserById(id);
        return ResponseEntity.ok(userById);
    }

    // Update User
    @PutMapping("/user/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        UserDto updateUser = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updateUser);
    }

    //Delete User
    @DeleteMapping("/delUser/{userId}")
    public Boolean deleteUser(@PathVariable Long userId) {
        this.userService.deleteUser(userId);
        return true;
    }

}
