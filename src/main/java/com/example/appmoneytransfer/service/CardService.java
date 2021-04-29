package com.example.appmoneytransfer.service;

import com.example.appmoneytransfer.entity.Card;
import com.example.appmoneytransfer.payload.CardDto;
import com.example.appmoneytransfer.payload.Result;
import com.example.appmoneytransfer.repository.CardRepository;
import com.example.appmoneytransfer.security.JwtFilter;
import com.example.appmoneytransfer.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    JwtFilter jwtFilter;


    /**
     * ADD CARD
     *
     * @param cardDto
     * @return RESULT
     */
    public Result addCard(CardDto cardDto) {
        boolean existsByNumber = cardRepository.existsByNumber(cardDto.getNumber());
        if (existsByNumber) {
            return new Result(false, "Card already exist");
        }

        Card card = new Card();
        card.setUsername(jwtFilter.username);
        card.setNumber(cardDto.getNumber());
        card.setExpireDate(cardDto.getExpireDate());
        cardRepository.save(card);

        return new Result(true, "Card successfully added");
    }

    public List<Card> getCardByUsername() {
        String username = jwtFilter.username;
        return cardRepository.findAllByUsername(username);
    }

    public List<Card> get() {
        return cardRepository.findAll();
    }
}
