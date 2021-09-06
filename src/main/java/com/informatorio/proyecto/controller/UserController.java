package com.informatorio.proyecto.controller;

import com.informatorio.proyecto.entity.User;
import com.informatorio.proyecto.repository.UserRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAllUsers(
            @RequestParam(name = "dateUser", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO:DATE)LocalDateTime dateUser,
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName,
            @RequestParam(name = "address", required = false) String address) {
        if (dateUser != null) {
            return new ResponseEntity<>(userRepository.findByDateUserAfter(dateUser.asStartOfDay()), HttpStatus.OK);
        }
        else if (Objects.nonNull(firstName) && Objects.nonNull(lastName) && Objects.nonNull(address)) {
            return new ResponseEntity<>(userRepository.findByFirstNameContainingAndLastNameContainingAndAddressContaining(firstName, lastName, address), HttpStatus.OK);
        }
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
}





























