package ru.netology.quantummoney.model;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
