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

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;


    public UserController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/users")
    public ResponseEntity<UsersDTO> getAll() {
        final List<User> users = queryBus.send(new RetrieveUsers());
        UsersDTO usersDTOResult = new UsersDTO(users.stream().map(user -> new UserDTO(user.getUserId(), user.getLastname(), user.getFirstname(), user.getAge(), user.getCity(), user.getPassword(), user.getEmail(), user.getPassword(), user.getTrade(), user.getPaymentMethod())).collect(Collectors.toList()));
        return ResponseEntity.ok(usersDTOResult);
    }


    @GetMapping(path = "/users/city/{city}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersDTO> getAllByCity(@PathVariable("city") String city) {
        final List<User> users = queryBus.send(new RetrieveUsersByCity(city));
        UsersDTO usersDTOResult = new UsersDTO(users.stream().map(user -> new UserDTO(user.getUserId(), user.getLastname(), user.getFirstname(), user.getAge(), user.getCity(), user.getPassword(), user.getEmail(), user.getPassword(), user.getTrade(), user.getPaymentMethod())).collect(Collectors.toList()));
        return ResponseEntity.ok(usersDTOResult);
    }


    @GetMapping(path = "/users/{id}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") long id) {
        final User user = queryBus.send(new RetrieveUserById(id));
        UserDTO userDTO = new UserDTO(id, user.getLastname(), user.getFirstname(), user.getAge(), user.getCity(), user.getPassword(), user.getEmail(), user.getPassword(), user.getTrade(), user.getPaymentMethod());
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@Valid @RequestBody UserDTO userDTO) {
        CreateUser createUser = new CreateUser(userDTO.getLastname(), userDTO.getFirstname(), userDTO.getAge(), userDTO.getCity(), userDTO.getPassword(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getTrade(), userDTO.getPaymentMethod());
        Long userId = commandBus.send(createUser);
        return ResponseEntity.created(URI.create("/users/" + userId)).build();
    }

    @DeleteMapping(path = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        Long userId = commandBus.send(new DeleteUser(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@Valid @RequestBody UserDTO userDTO, @PathVariable(name="id") long id){
        UpdateUser updateUser = new UpdateUser(id,userDTO.getLastname(), userDTO.getFirstname(), userDTO.getAge(), userDTO.getCity(), userDTO.getPassword(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getTrade(), userDTO.getPaymentMethod());
        Long userId = commandBus.send(updateUser);
        return new ResponseEntity<>(HttpStatus.OK);

    }



}
