package com.CrudTask.demo.services.implementation;
import com.CrudTask.demo.dto.UserDto;
import com.CrudTask.demo.models.User;
import com.CrudTask.demo.repository.UserRepository;
import com.CrudTask.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    // Create a new User
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userTodto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail((userDto.getEmail()));
        user.setUserIdNumber(userDto.getUserId());
        user.setRole(userDto.getRole());
        user.setDescription(userDto.getDescription());
        User updateUser = this.userRepository.save(user);
        return this.userTodto(updateUser);
    }
    @Override
    public UserDto getUserById(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow();
        return this.userTodto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = (List<User>) this.userRepository.findAll();

        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = this.userTodto(user);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public void deleteUser(Long userID) {
        User user = this.userRepository.findById(userID).orElseThrow(() -> new RuntimeException("User Not Found"));
        this.userRepository.delete(user);
    }
    private User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }

    public UserDto userTodto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
