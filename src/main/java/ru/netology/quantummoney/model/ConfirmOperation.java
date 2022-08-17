package ru.netology.quantummoney.model;

import javax.validation.constraints.*;

public class ConfirmOperation {
    @NotEmpty(message = "Invalid operationId: Empty operationId")
    @Positive(message = "Invalid operationId: Only operationId > 0")
    private String operationId;
    @Size(min = 4, message = "Invalid code: Must be min 4 characters")
    @NotBlank(message = "Invalid code: Empty code")
    private String code;
    private double transferFee;

    public ConfirmOperation(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTransferFee(double transferFee) {
        this.transferFee = transferFee;
    }

    public String getOperationId() {
        return operationId;
    }

    public String getCode() {
        return code;
    }

    public double getTransferFee() {
        return transferFee;
    }

    @Override
    public String toString() {
        return "ConfirmOperation{" +
                "operationId='" + operationId + '\'' +
                ", code='" + code + '\'' +
                ", transferFee=" + transferFee +
                '}';
    }
}
