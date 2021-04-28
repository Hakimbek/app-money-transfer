package com.example.appmoneytransfer.service;

import com.example.appmoneytransfer.entity.Income;
import com.example.appmoneytransfer.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {
    @Autowired
    IncomeRepository incomeRepository;

    /**
     * GET INCOMES BY TO CARD ID
     *
     * @param id INTEGER
     * @return LIST OF INCOMES
     */
    public List<Income> get(Integer id) {
        return incomeRepository.findAllByToCardIdId(id);
    }
}
