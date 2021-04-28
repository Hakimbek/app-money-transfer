package com.example.appmoneytransfer.repository;

import com.example.appmoneytransfer.entity.Income;
import com.example.appmoneytransfer.projection.IncomeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "income", excerptProjection = IncomeProjection.class)
public interface IncomeRepository extends JpaRepository<Income, Integer> {
    boolean existsById(Integer id);

    List<Income> findAllByToCardIdId(Integer toCardId_id);
}

