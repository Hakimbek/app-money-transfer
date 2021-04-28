package com.example.appmoneytransfer.controller;

import com.example.appmoneytransfer.entity.Income;
import com.example.appmoneytransfer.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {
    @Autowired
    IncomeService incomeService;

    /**
     * GET INCOMES BY TO CARD ID
     *
     * @param id INTEGER
     * @return LIST OF INCOMES
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getByToCardId(@PathVariable Integer id) {
        List<Income> incomes = incomeService.get(id);
        return ResponseEntity.status(incomes != null ? 200 : 409).body(incomes);
    }
}
