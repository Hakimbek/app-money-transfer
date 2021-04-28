package com.example.appmoneytransfer.projection;

import com.example.appmoneytransfer.entity.Card;
import com.example.appmoneytransfer.entity.Outcome;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;

@Projection(types = Outcome.class)
public interface OutcomeProjection {
    Integer getId();

    Card getFromCardId();

    Card getToCardId();

    Double getAmount();

    LocalDateTime getDateTime();

    Double getCommissionAmount();
}
