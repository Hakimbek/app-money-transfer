package com.example.appmoneytransfer.projection;

import com.example.appmoneytransfer.entity.Card;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(types = Card.class)
public interface CardProjection {
    Integer getId();

    String getUsername();

    Long getNumber();

    Double getBalance();

    String getCurrency();

    Date getExpireDate();

    Boolean getActive();
}
