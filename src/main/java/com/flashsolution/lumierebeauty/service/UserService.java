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

    // 1. Repository and password encoder
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 2. Register a new customer
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

    // 3. Login user
    public User loginUser(User loginRequest) {

        if (loginRequest.getEmail() == null
                || loginRequest.getEmail().isBlank()
                || loginRequest.getPassword() == null
                || loginRequest.getPassword().isBlank()) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Email and password are required"
            );
        }

        // Find user by email
        String email = loginRequest.getEmail().trim().toLowerCase();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "Invalid email or password"
                ));

        // Check password
        if (!passwordEncoder.matches(
                loginRequest.getPassword(),
                user.getPassword()
        )) {

            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid email or password"
            );
        }

        return user;
    }

    // 4. Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 5. Get user by ID
    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User not found with ID: " + id
                ));
    }

    // 6. Update user
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

        // Update password only when a new password is provided
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

    // 7. Delete user
    public void deleteUser(Long id) {

        User user = getUserById(id);

        userRepository.delete(user);
    }
}