package com.example.blog.services;

import com.example.blog.entity.User;
import com.example.blog.payloads.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

   UserDTO createUser(UserDTO user);
   UserDTO updateUser(UserDTO userDTO,String userId);
   UserDTO getUserById(String userId);
   List<UserDTO> getAllUser();

   void deleteUser(String userId);


}
