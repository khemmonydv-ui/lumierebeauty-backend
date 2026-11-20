package com.flashsolution.lumierebeauty.controller;

import com.flashsolution.lumierebeauty.entity.User;
import com.flashsolution.lumierebeauty.service.UserService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 1. Register a new user
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

        User newUser = userService.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // 2. Login user
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User loginRequest) {

        User loggedInUser = userService.loginUser(loginRequest);

        return ResponseEntity.ok(loggedInUser);
    }

    // 3. Get all users
    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    // 4. Get user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    // 5. Update user
    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody User updatedUser) {

        return userService.updateUser(id, updatedUser);
    }

    // 6. Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}