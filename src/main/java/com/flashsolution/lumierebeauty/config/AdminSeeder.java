package com.flashsolution.lumierebeauty.config;

import com.flashsolution.lumierebeauty.entity.User;
import com.flashsolution.lumierebeauty.entity.Role;
import com.flashsolution.lumierebeauty.repository.UserRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AdminSeeder {

    @Bean
    public CommandLineRunner createAdmin(
            UserRepository userRepository,
            @Value("${ADMIN_EMAIL:admin@lumierebeauty.com}") String adminEmail,
            @Value("${ADMIN_PASSWORD}") String adminPassword
    ) {
        return args -> {

            if (!userRepository.existsByEmail(adminEmail)) {

                BCryptPasswordEncoder passwordEncoder =
                        new BCryptPasswordEncoder();

                User admin = new User();

                admin.setName("Lumiere Admin");
                admin.setEmail(adminEmail);
                admin.setPassword(passwordEncoder.encode(adminPassword));
                admin.setRole(Role.ADMIN);

                userRepository.save(admin);

                System.out.println("Admin account created successfully!");

            } else {
                System.out.println("Admin account already exists.");
            }
        };
    }
}