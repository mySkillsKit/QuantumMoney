package ru.netology.quantummoney.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class MoneyTransfer {
    private long id;
    @Size(min = 16, max = 16)
    private String cardFromNumber;
    @Size(min = 4, max = 5)
    private String cardFromValidTill;
    @Size(min = 3, max = 3)
    private String cardFromCVV;
    @Size(min = 16, max = 16)
    private String cardToNumber;
    @Valid
    private Amount amount;
    private ConfirmOperation confirmOperation;


    public MoneyTransfer(String cardFromNumber, String cardFromValidTill,
                         String cardFromCVV, String cardToNumber, Amount amount) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCardFromNumber(String cardFromNumber) {
        this.cardFromNumber = cardFromNumber;
    }

    public void setCardFromValidTill(String cardFromValidTill) {
        this.cardFromValidTill = cardFromValidTill;
    }

    public void setCardFromCVV(String cardFromCVV) {
        this.cardFromCVV = cardFromCVV;
    }

    public void setCardToNumber(String cardToNumber) {
        this.cardToNumber = cardToNumber;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }


    public long getId() {
        return id;
    }

    public ConfirmOperation getConfirmOperation() {
        return confirmOperation;
    }

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public Amount getAmount() {
        return amount;
    }


    public void setConfirmOperation(ConfirmOperation confirmOperation) {
        this.confirmOperation = confirmOperation;
    }

    @Override
    public String toString() {
        return "MoneyTransfer{" +
                "id=" + id +
                ", cardFromNumber='" + cardFromNumber + '\'' +
                ", cardFromValidTill='" + cardFromValidTill + '\'' +
                ", cardFromCVV='" + cardFromCVV + '\'' +
                ", cardToNumber='" + cardToNumber + '\'' +
                ", amount=" + amount +
                ", confirmOperation=" + confirmOperation +
                '}';
    }
}
