package com.example.appmoneytransfer.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OutcomeDto {
    @NotNull(message = "formCardId must not be empty")
    private Integer formCardId;

    @NotNull(message = "toCardId must not be empty")
    private Integer toCardId;

    @NotNull(message = "amount must not be empty")
    private Double amount;
}
