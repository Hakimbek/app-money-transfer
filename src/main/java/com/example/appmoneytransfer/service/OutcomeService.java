package com.example.appmoneytransfer.service;

import com.example.appmoneytransfer.entity.Card;
import com.example.appmoneytransfer.entity.Income;
import com.example.appmoneytransfer.entity.Outcome;
import com.example.appmoneytransfer.payload.OutcomeDto;
import com.example.appmoneytransfer.payload.Result;
import com.example.appmoneytransfer.repository.CardRepository;
import com.example.appmoneytransfer.repository.IncomeRepository;
import com.example.appmoneytransfer.repository.OutcomeRepository;
import com.example.appmoneytransfer.security.JwtFilter;
import com.example.appmoneytransfer.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutcomeService {
    @Autowired
    OutcomeRepository outcomeRepository;
    @Autowired
    IncomeRepository incomeRepository;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    JwtFilter jwtFilter;


    /**
     * TRANSFER MONEY TO ANOTHER CARD
     *
     * @param outcomeDto
     * @return RESULT
     */
    public Result transferMoney(OutcomeDto outcomeDto) {
        // FIND FROM CARD BY ID
        Optional<Card> optionalFromCard = cardRepository.findById(outcomeDto.getFormCardId());
        if (!optionalFromCard.isPresent()) {
            return new Result(false, "From card not found");
        }
        Card fromCard = optionalFromCard.get();

        // FIND TO CARD BY ID
        Optional<Card> optionalToCard = cardRepository.findById(outcomeDto.getToCardId());
        if (!optionalToCard.isPresent()) {
            return new Result(false, "To card not found");
        }
        Card toCard = optionalToCard.get();

        // CHECK OUT, USER USERNAME ADN CARD USERNAME
        String username = jwtFilter.username;
        if (!fromCard.getUsername().equals(username)) {
            return new Result(false, "This is not your card");
        }

        // CHECK OUT, CARD ID
        if (fromCard.getId().equals(toCard.getId())) {
            return new Result(false, "Cards equal");
        }

        // CHECK OUT, CARD HAS ENOUGH MONEY FOR TRANSFER
        if(fromCard.getBalance() < (outcomeDto.getAmount() + outcomeDto.getAmount() * 0.1)) {
            return new Result(false, "Not enough money");
        }

        // SAVE EDITED FROM CARD
        fromCard.setBalance(fromCard.getBalance() - (outcomeDto.getAmount() + outcomeDto.getAmount() * 0.1));
        Card savedFromCard = cardRepository.save(fromCard);

        // SAVE EDITED TO CARD
        toCard.setBalance(toCard.getBalance() + outcomeDto.getAmount());
        Card savedToCard = cardRepository.save(toCard);

        // SAVE OUTCOME
        Outcome outcome = new Outcome();
        outcome.setAmount(outcomeDto.getAmount());
        outcome.setFromCardId(savedFromCard);
        outcome.setToCardId(savedToCard);
        outcomeRepository.save(outcome);

        // SAVE INCOME
        Income income = new Income();
        income.setAmount(outcomeDto.getAmount());
        income.setToCardId(savedToCard);
        income.setFromCardId(savedFromCard);
        incomeRepository.save(income);
        return new Result(true, "Money successfully transferred");
    }


    /**
     * GET OUTCOMES BY FROM CARD ID
     *
     * @param id INTEGER
     * @return LIST OF OUTCOMES
     */
    public List<Outcome> get(Integer id) {
        return outcomeRepository.findAllByFromCardIdId(id);
    }
}
