package com.example.appmoneytransfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Username must not be empty")
    private String username;

    @NotNull(message = "Number must not be empty")
    private Long number;

    private Double balance = 500_000.0;

    private String currency = "UZS";

    @NotNull(message = "ExpireDate must not be empty")
    private Date expireDate;

    private Boolean active = true;
}
