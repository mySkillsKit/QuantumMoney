package ru.netology.quantummoney.model;

public class ConfirmOperation {
    private String operationId;
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
