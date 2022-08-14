package ru.netology.quantummoney.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.quantummoney.exception.ErrorTransferOrConfirm;
import ru.netology.quantummoney.exception.InvalidInputData;
import ru.netology.quantummoney.model.ErrorMsg;

@RestControllerAdvice
public class ExceptionHandlerAdvice {


    @ExceptionHandler(ErrorTransferOrConfirm.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMsg errHandler(ErrorTransferOrConfirm exc) {
        return new ErrorMsg(exc.getMessage(), exc.getId());
    }

    @ExceptionHandler(InvalidInputData.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMsg iidHandler(InvalidInputData exc) {
        return new ErrorMsg(exc.getMessage(), exc.getId());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMsg notvalidHandler(MethodArgumentNotValidException exc) {
        return new ErrorMsg("Error input data " + exc.getMessage(), 0);
    }

}