package ru.netology.quantummoney.model;

import lombok.Data;

@Data
public class SuccessResponse {
    private final String operationId;

    public SuccessResponse(String operationId) {
        this.operationId = operationId;
    }

    @Override
    public String toString() {
        return "SuccessResponse{" +
                "operationId='" + operationId + '\'' +
                '}';
    }

}
