package com.springboot.trademe.use_cases.user.exposition;

import com.springboot.trademe.kernel.CommandBus;
import com.springboot.trademe.kernel.QueryBus;
import com.springboot.trademe.use_cases.user.application.create.CreateUser;
import com.springboot.trademe.use_cases.user.application.delete.DeleteUser;
import com.springboot.trademe.use_cases.user.application.read.RetrieveUserById;
import com.springboot.trademe.use_cases.user.application.read.RetrieveUsers;
import com.springboot.trademe.use_cases.user.application.read.RetrieveUsersByCity;
import com.springboot.trademe.use_cases.user.application.update.UpdateUser;
import com.springboot.trademe.use_cases.user.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserControllerHandler {

    private final CommandBus commandBus;
    private final QueryBus queryBus;


    public UserControllerHandler(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/users", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersDTO> getAll() {
        final List<User> users = queryBus.send(new RetrieveUsers());
        UsersDTO usersDTOResult = new UsersDTO(users.stream().map(user -> new UserDTO(user.getUserId(), user.getLastname(), user.getFirstname(), user.getAge(), user.getCity(), user.getPassword(), user.getEmail(), user.getPassword(), user.getTrade())).collect(Collectors.toList()));
        return ResponseEntity.ok(usersDTOResult);
    }

    @GetMapping(path = "/users/{city}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersDTO> getAllByCity(@PathVariable(name="city") String city) {
        final List<User> users = queryBus.send(new RetrieveUsersByCity(city));
        UsersDTO usersDTOResult = new UsersDTO(users.stream().map(user -> new UserDTO(user.getUserId(), user.getLastname(), user.getFirstname(), user.getAge(), user.getCity(), user.getPassword(), user.getEmail(), user.getPassword(), user.getTrade())).collect(Collectors.toList()));
        return ResponseEntity.ok(usersDTOResult);
    }

    @GetMapping(path = "/users/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDTO> getProjectById(@PathVariable(name="id") Long id) {
        final User user = queryBus.send(new RetrieveUserById(id));
        UserDTO userDTO = new UserDTO(id, user.getLastname(), user.getFirstname(), user.getAge(), user.getCity(), user.getPassword(), user.getEmail(), user.getPassword(), user.getTrade());
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody UserDTO userDTO) {
        CreateUser createUser = new CreateUser(userDTO.getLastname(), userDTO.getFirstname(), userDTO.getAge(), userDTO.getCity(), userDTO.getPassword(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getTrade());
        Long userId = commandBus.send(createUser);
        return ResponseEntity.created(URI.create("/users/" + userId)).build();
    }


    // à refaire
    @DeleteMapping(path = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable(name="id") Long id){
        Long userId = commandBus.send(new DeleteUser(id));
        return new ResponseEntity<>("Project with id " +userId+ " has been successfully deleted.", HttpStatus.OK);
    }

    // à refaire
    @PutMapping(path = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@RequestBody UserDTO userDTO, @PathVariable(name="id") long id){
        UpdateUser updateUser = new UpdateUser(id,userDTO.getLastname(), userDTO.getFirstname(), userDTO.getAge(), userDTO.getCity(), userDTO.getPassword(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getTrade());
        Long userId = commandBus.send(updateUser);
        return new ResponseEntity<>("Project with id " +userId+ " has been successfully updated.", HttpStatus.OK);

    }



}
