package com.flashsolution.lumierebeauty.config;

import com.flashsolution.lumierebeauty.entity.User;
import com.flashsolution.lumierebeauty.entity.Role;
import com.flashsolution.lumierebeauty.entity.UserStatus;
import com.flashsolution.lumierebeauty.repository.UserRepository;

import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.Locale;

@Configuration
public class AdminSeeder {

    @Bean
    public CommandLineRunner createAdmin(
            UserRepository userRepository,
            Validator validator,
            @Value("${ADMIN_EMAIL:admin@lumierebeauty.com}") String adminEmail,
            @Value("${ADMIN_PASSWORD}") String adminPassword
    ) {
        return args -> {

            // Normalize admin email
            String normalizedEmail = adminEmail.trim().toLowerCase(Locale.ROOT);

            // Check whether admin already exists
            if (userRepository.existsByEmail(adminEmail)) {
                System.out.println("Admin account already exists.");
                return;
            }

            // Create admin user
            User admin = new User();

            admin.setName("Lumiere Admin");
            admin.setEmail(adminEmail);
            admin.setPassword(adminPassword);
            admin.setRole(Role.ADMIN);
            admin.setStatus(UserStatus.ACTIVE);

            // Validate admin information
            Set<ConstraintViolation<User>> violations =
                    validator.validate(admin);

            if (!violations.isEmpty()) {

                String errors = violations.stream()
                        .map(ConstraintViolation::getMessage)
                        .collect(Collectors.joining(", "));

                throw new IllegalStateException(
                        "Invalid admin configuration: " + errors
                );
            }

            // Encrypt password after validation
            BCryptPasswordEncoder passwordEncoder =
                    new BCryptPasswordEncoder();

            admin.setPassword(passwordEncoder.encode(adminPassword));

            // Save admin to database
            userRepository.save(admin);

            System.out.println("Admin account created successfully!");
        };
    }
}