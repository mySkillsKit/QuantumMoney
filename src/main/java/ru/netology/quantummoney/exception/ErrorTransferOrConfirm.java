package ru.netology.quantummoney.exception;


public class ErrorTransferOrConfirm extends RuntimeException {
    private final long id;

    public ErrorTransferOrConfirm(String msg, long id) {
        super(msg);
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
