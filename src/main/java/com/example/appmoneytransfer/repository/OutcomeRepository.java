package com.example.appmoneytransfer.repository;

import com.example.appmoneytransfer.entity.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutcomeRepository extends JpaRepository<Outcome, Integer> {
    List<Outcome> findAllByFromCardIdId(Integer fromCardId);
}
