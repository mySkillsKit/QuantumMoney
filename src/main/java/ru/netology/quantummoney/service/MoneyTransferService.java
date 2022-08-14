package ru.netology.quantummoney.service;

import org.springframework.stereotype.Service;
import ru.netology.quantummoney.exception.ErrorTransferOrConfirm;
import ru.netology.quantummoney.exception.InvalidInputData;
import ru.netology.quantummoney.model.ConfirmOperation;
import ru.netology.quantummoney.model.MoneyTransfer;
import ru.netology.quantummoney.model.SuccessResponse;
import ru.netology.quantummoney.repository.MoneyTransferRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class MoneyTransferService {
    private final MoneyTransferRepository repository;

    public MoneyTransferService(MoneyTransferRepository repository) {
        this.repository = repository;
    }

    public List<MoneyTransfer> all() {
        return repository.all();
    }

    public MoneyTransfer getById(long id) {
        //todo
        return repository.getById(id).orElse(null);
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
