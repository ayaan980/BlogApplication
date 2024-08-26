package com.example.blog.services.impl;

import com.example.blog.entity.User;
import com.example.blog.exceptions.ResourceNotFoundException;
import com.example.blog.payloads.UserDTO;
import com.example.blog.repositries.UserRepo;
import com.example.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        String randomUserId = UUID.randomUUID().toString();
        userDTO.setId(randomUserId);
        User user=this.dtoToUser(userDTO);
        User savedUser= this.userRepo.save(user);
        return this.userToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, String userId) {
        User user=this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAbout(userDTO.getAbout());

        User updatedUser = this.userRepo.save(user);
        UserDTO userDTO1=this.userToDTO(updatedUser);
        return null;
    }

    @Override
    public UserDTO getUserById(String userId) {
        User user=this.userRepo
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException());
        return this.userToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> userList = this.userRepo.findAll();
        List<UserDTO> collect = userList.stream().map(user -> this.userToDTO(user)).collect(Collectors.toList());
    return collect;
    }


    @Override
    public void deleteUser(String userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException());
        this.userRepo.delete(user);
    }

    private User dtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setAbout(userDTO.getAbout());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public UserDTO userToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setAbout(user.getAbout());
        return userDTO;
    }
}
