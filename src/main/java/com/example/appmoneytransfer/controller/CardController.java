package com.example.appmoneytransfer.controller;

import com.example.appmoneytransfer.entity.Card;
import com.example.appmoneytransfer.payload.CardDto;
import com.example.appmoneytransfer.payload.Result;
import com.example.appmoneytransfer.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    CardService cardService;

    /**
     * ADD CARD
     *
     * @param cardDto
     * @return RESULT
     */
    @PostMapping
    public ResponseEntity<?> addCard(@RequestBody CardDto cardDto) {
        Result result = cardService.addCard(cardDto);
        return ResponseEntity.status(result.getSuccess() ? 201 : 409).body(result.getMessage());
    }

    /**
     * GET ALL CARD
     *
     * @return LIST OF CARDS
     */
    @GetMapping
    public ResponseEntity<?> get() {
        List<Card> cards = cardService.get();
        return ResponseEntity.status(cards != null ? 200 : 404).body(cards);
    }
}
