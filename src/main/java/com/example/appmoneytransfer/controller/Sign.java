package com.example.appmoneytransfer.controller;

import com.example.appmoneytransfer.payload.SignInDto;
import com.example.appmoneytransfer.security.JwtProvider;
import com.example.appmoneytransfer.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sign")
public class Sign {
    @Autowired
    AuthService authService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;


    /**
     * SIGN IN
     *
     * @param signInDto USERNAME, PASSWORD
     * @return STRING
     */
    @PostMapping("/in")
    public ResponseEntity<?> signIn(@RequestBody SignInDto signInDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    signInDto.getUsername(), signInDto.getPassword()));

            String token = jwtProvider.generateJwt(signInDto.getUsername());
            return ResponseEntity.ok(token);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Username or password error");
        }
    }
}
