package com.example.ecommers.user.service;

import com.example.ecommers.user.entity.Users;
import com.example.ecommers.user.repository.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {

        // 1. Fetch user from PostgreSQL
        Users user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("Username not found!" + username)
        );

        // 2. Wrap it in Spring's UserDetails format
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getRole().stream()
                        .map(role -> "ROLE_" + role) // important prefix
                        .toArray(String[]::new))
                .build();



    }
}
