package ru.netology.quantummoney.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.quantummoney.exception.ErrorTransferOrConfirm;
import ru.netology.quantummoney.exception.InvalidInputData;
import ru.netology.quantummoney.model.ConfirmOperation;
import ru.netology.quantummoney.model.MoneyTransfer;
import ru.netology.quantummoney.model.SuccessResponse;
import ru.netology.quantummoney.repository.MoneyTransferRepository;

import java.time.LocalDate;

@Slf4j
@Service
public class MoneyTransferService {
    private final MoneyTransferRepository repository;

    @Autowired
    public MoneyTransferService(MoneyTransferRepository repository) {
        this.repository = repository;
    }

    public SuccessResponse saveMoneyTransfer(MoneyTransfer transfer) {
        //Getting the current date value of the system
        LocalDate currentDate = LocalDate.now(); //"currentDate": "08/22"
        //System.out.println("Current date: " + currentDate);
        //getting the current year and month from the current_date
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();

        String[] parts = transfer.getCardFromValidTill().split("/"); //  "cardFromValidTill": "09/22"
        int cardFromValidTillMonth = Integer.parseInt(parts[0]);
        int cardFromValidTillYear = Integer.parseInt(parts[1]) + 2000;

        if (cardFromValidTillYear <= currentYear && cardFromValidTillMonth < currentMonth) {
            throw new InvalidInputData("Invalid input data: card expired " + transfer.getCardFromValidTill(), 0);
        }
        log.info("The input data Money Transfer is correct!");

        return repository.saveMoneyTransfer(transfer);
    }

    public SuccessResponse saveConfirmOperation(ConfirmOperation confirmOperation) {
        //Условная реализация по проверке кода подтверждения денежного перевода с БД
        if (false) {
            throw new ErrorTransferOrConfirm(
                    "Money transfer not confirmed /check verification code", 0);
        }
        return repository.saveConfirmOperation(confirmOperation);
    }

}
