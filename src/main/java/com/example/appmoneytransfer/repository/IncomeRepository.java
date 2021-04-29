package com.example.appmoneytransfer.repository;

import com.example.appmoneytransfer.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Integer> {
    boolean existsById(Integer id);

    List<Income> findAllByToCardIdId(Integer toCardId_id);
}

