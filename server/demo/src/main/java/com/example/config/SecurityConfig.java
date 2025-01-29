package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig {

    private final String USERS_FILE = "src/main/resources/users.txt";

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Map<String, String> users = loadUsersFromFile();
            if (users.containsKey(username)) {
                return User.withUsername(username)
                        .password(passwordEncoder().encode(users.get(username)))
                        .roles("USER")
                        .build();
            } else {
                throw new RuntimeException("User not found");
            }
        };
    }

    private Map<String, String> loadUsersFromFile() {
        Map<String, String> users = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]); // username -> password
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading users file", e);
        }
        return users;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
