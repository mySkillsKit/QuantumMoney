package ru.netology.quantummoney.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Amount {
    @Positive(message = "Invalid value: Must be value > 0")
    private final int value;
    @NotEmpty(message = "Invalid currency: Empty operationId")
    @Size(min = 3, max = 3, message = "Invalid currency: Must be 3 characters (RUB/USD/EUR)")
    private final String currency;


    public Amount(int value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public int getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
