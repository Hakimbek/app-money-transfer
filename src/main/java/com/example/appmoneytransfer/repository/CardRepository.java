package com.example.appmoneytransfer.repository;

import com.example.appmoneytransfer.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {
    boolean existsByNumber(Long number);

    List<Card> findAllByUsername(String username);
}
