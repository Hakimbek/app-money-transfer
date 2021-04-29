package com.example.appmoneytransfer.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CardDto {
    @NotNull(message = "number must not be empty")
    private Long number;

    @NotNull(message = "expireDate must not be empty")
    private Date expireDate;
}
