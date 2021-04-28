package com.example.appmoneytransfer.repository;

import com.example.appmoneytransfer.entity.Outcome;
import com.example.appmoneytransfer.projection.OutcomeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "outcome", excerptProjection = OutcomeProjection.class)
public interface OutcomeRepository extends JpaRepository<Outcome, Integer> {
    List<Outcome> findAllByFromCardIdId(Integer fromCardId);
}
