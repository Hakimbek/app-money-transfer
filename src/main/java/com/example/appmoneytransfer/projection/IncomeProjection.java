package com.example.appmoneytransfer.projection;

import com.example.appmoneytransfer.entity.Card;
import com.example.appmoneytransfer.entity.Income;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;

@Projection(types = Income.class)
public interface IncomeProjection {
    Integer getId();

    Card getFromCardId();

    Card getToCardId();

    Double getAmount();

    LocalDateTime getDateTime();
}
