package com.springboot.trademe.use_cases.user.application;

import com.springboot.trademe.kernel.exception.ResourceNotFoundException;
import com.springboot.trademe.use_cases.user.domain.User;
import com.springboot.trademe.use_cases.user.domain.UserRepository;
import com.springboot.trademe.use_cases.user.exposition.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultUserService implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public DefaultUserService(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = mapToEntity(userDTO);
        User newUser = this.userRepository.save(user);
        return mapToDTO(newUser);    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users.stream().map(user -> mapToDTO(user)).collect(Collectors.toList());    }

    @Override
    public UserDTO getUserById(long id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id", id));
        return mapToDTO(user);    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, long id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id", id));

        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setAge(userDTO.getAge());
        user.setCity(userDTO.getCity());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setTrade(userDTO.getTrade());
        User updatedUser = userRepository.save(user);

        return mapToDTO(updatedUser);    }

    @Override
    public void deleteUser(long id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id", id));
        this.userRepository.delete(user);
    }


    private UserDTO mapToDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }


    private User mapToEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }

}
