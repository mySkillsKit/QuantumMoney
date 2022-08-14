package ru.netology.quantummoney.model;

import lombok.Data;

@Data
public class ErrorMsg {
    private final String message;
    private final long id;

    public ErrorMsg(String message, long id) {
        this.message = message;
        this.id = id;
    }
}
