package ru.netology.quantummoney.model;

import lombok.Data;

import javax.validation.constraints.*;
@Data
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

}
