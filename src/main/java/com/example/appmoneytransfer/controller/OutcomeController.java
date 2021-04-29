package com.example.appmoneytransfer.controller;

import com.example.appmoneytransfer.entity.Outcome;
import com.example.appmoneytransfer.payload.OutcomeDto;
import com.example.appmoneytransfer.payload.Result;
import com.example.appmoneytransfer.service.OutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/outcome")
public class OutcomeController {
    @Autowired
    OutcomeService outcomeService;

    /**
     * TRANSFER MONEY TO ANOTHER CARD
     *
     * @param outcomeDto
     * @return RESULT
     */
    @PostMapping
    public ResponseEntity<?> transferMoney(@RequestBody OutcomeDto outcomeDto) {
        Result result = outcomeService.transferMoney(outcomeDto);
        return ResponseEntity.status(result.getSuccess() ? 200 : 409).body(result.getMessage());
    }


    /**
     * GET OUTCOMES BY FROM CARD ID
     *
     * @param id INTEGER
     * @return LIST OF OUTCOMES
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getByFromCardId(@PathVariable Integer id) {
        List<Outcome> outcomes = outcomeService.get(id);
        return ResponseEntity.status(outcomes != null ? 200 : 409).body(outcomes);
    }
}
