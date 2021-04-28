package com.example.appmoneytransfer.payload;

import lombok.Data;

@Data
public class OutcomeDto {
    private Integer formCardId;

    private Integer toCardId;

    private Double amount;
}
