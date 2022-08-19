package ru.netology.quantummoney.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MoneyTransfer {
    private long id;
    @Pattern(regexp = "\\d{16}", message = "Invalid cardFromNumber: Must be 16 characters")
    private String cardFromNumber;
    @Pattern(regexp = "[01][0-9]/[2-9][0-9]", message = "Invalid cardFromValidTill: Must be MM/YY")
    private String cardFromValidTill;
    @Size(min = 3, message = "Invalid cardFromCVV: Must be min 3 characters")
    private String cardFromCVV;
    @Pattern(regexp = "\\d{16}", message = "Invalid cardToNumber: Must be 16 characters")
    private String cardToNumber;
    @Valid
    private Amount amount;
    private StatusMoneyTransfer statusMoneyTransfer;
    private ConfirmOperation confirmOperation;

    public MoneyTransfer(String cardFromNumber, String cardFromValidTill,
                         String cardFromCVV, String cardToNumber, Amount amount) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{" +
                "cardFromNumber='" + cardFromNumber + '\'' +
                ", cardFromValidTill='" + cardFromValidTill + '\'' +
                ", cardFromCVV='" + cardFromCVV + '\'' +
                ", cardToNumber='" + cardToNumber + '\'' +
                ", " + amount +
                '}';
    }
}
