package com.springboot.trademe.use_cases.user.application;

import com.springboot.trademe.use_cases.user.exposition.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO postDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(long id);
    UserDTO updateUser(UserDTO userDTO, long id);
    void deleteUser(long id);



}
