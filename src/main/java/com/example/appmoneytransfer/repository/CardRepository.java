package com.example.appmoneytransfer.repository;

import com.example.appmoneytransfer.entity.Card;
import com.example.appmoneytransfer.projection.CardProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "card", excerptProjection = CardProjection.class)
public interface CardRepository extends JpaRepository<Card, Integer> {
    boolean existsByNumber(Long number);
}
