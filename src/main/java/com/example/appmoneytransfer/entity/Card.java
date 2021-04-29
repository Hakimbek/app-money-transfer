package com.example.appmoneytransfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private Long number;

    private Double balance = 500_000.0;

    private String currency = "UZS";

    @Column(nullable = false)
    private Date expireDate;

    @Column(nullable = false)
    private Boolean active = true;
}
