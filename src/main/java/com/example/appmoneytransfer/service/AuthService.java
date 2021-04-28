package com.example.appmoneytransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> userList = new ArrayList<>(
                Arrays.asList(
                        new User("Hakimbek", passwordEncoder.encode("123"), new ArrayList<>()),
                        new User("Bahodir", passwordEncoder.encode("456"), new ArrayList<>()),
                        new User("Jalol", passwordEncoder.encode("789"), new ArrayList<>())
                )
        );

        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("Username not found");
    }
}
