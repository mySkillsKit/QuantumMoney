package ru.netology.quantummoney.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class Amount {
    @Positive(message = "Invalid value: Must be value > 0")
    private final int value;
    @NotEmpty(message = "Invalid currency: Empty operationId")
    @Size(min = 3, max = 3, message = "Invalid currency: Must be 3 characters (RUB/USD/EUR)")
    private final String currency;
}
