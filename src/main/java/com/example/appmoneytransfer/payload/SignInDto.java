package com.example.appmoneytransfer.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SignInDto {
    @NotNull(message = "Username must not be empty")
    private String username;

    @NotNull(message = "Password must not be empty")
    private String password;
}
