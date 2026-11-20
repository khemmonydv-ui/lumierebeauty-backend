package com.flashsolution.lumierebeauty.controller;

import com.flashsolution.lumierebeauty.entity.User;
import com.flashsolution.lumierebeauty.entity.Role;
import com.flashsolution.lumierebeauty.entity.UserStatus;
import com.flashsolution.lumierebeauty.service.UserService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
public class AdminUserController {

    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    // 1. GET ALL USERS
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 2. GET USER BY ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // 3. CREATE USER
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User newUser = userService.createAdminUser(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newUser);
    }

    // 4. UPDATE USER INFORMATION
    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody User user) {

        return userService.updateUser(id, user);
    }

    // 5. UPDATE USER ROLE
    @PatchMapping("/{id}/role")
    public User updateUserRole(
            @PathVariable Long id,
            @RequestParam Role role) {

        return userService.updateUserRole(id, role);
    }

    // 6. UPDATE USER STATUS
    @PatchMapping("/{id}/status")
    public User updateUserStatus(
            @PathVariable Long id,
            @RequestParam UserStatus status) {

        return userService.updateUserStatus(id, status);
    }

    // 7. DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}