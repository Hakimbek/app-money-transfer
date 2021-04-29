package com.example.appmoneytransfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime dateTime = LocalDateTime.now();
}
