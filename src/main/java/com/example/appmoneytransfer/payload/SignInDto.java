package com.example.appmoneytransfer.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SignInDto {
    @NotNull(message = "username must not be empty")
    private String username;

    @NotNull(message = "password must not be empty")
    private String password;
}
