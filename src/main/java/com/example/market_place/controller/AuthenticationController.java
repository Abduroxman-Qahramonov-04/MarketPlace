package com.example.market_place.controller;

import com.example.market_place.jpa.UserRepository;
import com.example.market_place.exception.EmailAlreadyExists;
import com.example.market_place.exception.UserAlreadyExists;
import com.example.market_place.exception.UserNotFound;
import com.example.market_place.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class AuthenticationController {
    private final UserRepository userRepository;
    public AuthenticationController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping("/users")
    public List<User> getListOfUsers(){
        return this.userRepository.findAll();
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) throws UserNotFound {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) throw new UserNotFound("User with id not found "+ id);
        return user.get();
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Integer id){
        userRepository.deleteById(id);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).build();
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) throws UserAlreadyExists, EmailAlreadyExists {
        if(userRepository.findByUsernameIgnoreCase(user.getUsername()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Username already exists: " + user.getUsername());
        }
        if(userRepository.findByEmailIgnoreCase(user.getEmail()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email already exists: " + user.getEmail());
        }
        User temp_user = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{register}").buildAndExpand(temp_user.getId()).toUri();
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        return ResponseEntity.created(location).build();
    }
}
