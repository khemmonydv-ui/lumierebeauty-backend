package com.flashsolution.lumierebeauty.service;

import com.flashsolution.lumierebeauty.entity.User;
import com.flashsolution.lumierebeauty.entity.Role;
import com.flashsolution.lumierebeauty.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 1. Register a new customer
    public User createUser(User user) {

        if (user.getName() == null || user.getName().isBlank()
                || user.getEmail() == null || user.getEmail().isBlank()
                || user.getPassword() == null || user.getPassword().isBlank()) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Name, email and password are required"
            );
        }

        String email = user.getEmail().trim().toLowerCase();

        if (userRepository.existsByEmail(email)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email already exists"
            );
        }

        if (user.getPassword().length() < 8) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Password must be at least 8 characters"
            );
        }

        user.setId(null);
        user.setEmail(email);

        // Hash the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Public registration always creates CUSTOMER
        user.setRole(Role.CUSTOMER);

        return userRepository.save(user);
    }

    // 2. Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 3. Get user by ID
    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User not found with ID: " + id
                ));
    }

    // 4. Update user
    public User updateUser(Long id, User updatedUser) {

        User existingUser = getUserById(id);

        if (updatedUser.getName() == null
                || updatedUser.getName().isBlank()
                || updatedUser.getEmail() == null
                || updatedUser.getEmail().isBlank()) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Name and email are required"
            );
        }

        String email = updatedUser.getEmail().trim().toLowerCase();

        if (!existingUser.getEmail().equals(email)
                && userRepository.existsByEmail(email)) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email already exists"
            );
        }

        existingUser.setName(updatedUser.getName().trim());
        existingUser.setEmail(email);

        if (updatedUser.getPassword() != null
                && !updatedUser.getPassword().isBlank()) {

            if (updatedUser.getPassword().length() < 8) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Password must be at least 8 characters"
                );
            }

            existingUser.setPassword(
                    passwordEncoder.encode(updatedUser.getPassword())
            );
        }

        return userRepository.save(existingUser);
    }

    // 5. Delete user
    public void deleteUser(Long id) {

        User user = getUserById(id);

        userRepository.delete(user);
    }
}
