package com.example.appmoneytransfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private Card fromCardId;

    @ManyToOne(optional = false)
    private Card toCardId;

    @NotNull(message = "Amount must not be empty")
    private Double amount;

    @NotNull(message = "Date must not be null")
    private LocalDateTime dateTime = LocalDateTime.now();
}
