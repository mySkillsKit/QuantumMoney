package ru.netology.quantummoney.service;

import org.springframework.stereotype.Service;
import ru.netology.quantummoney.exception.InvalidInputData;
import ru.netology.quantummoney.model.ConfirmOperation;
import ru.netology.quantummoney.model.MoneyTransfer;
import ru.netology.quantummoney.model.SuccessResponse;
import ru.netology.quantummoney.repository.MoneyTransferRepository;

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

        return repository.saveMoneyTransfer(transfer);
    }

    public SuccessResponse saveConfirmOperation(ConfirmOperation confirmOperation) {
        if(isEmpty(confirmOperation.getOperationId()) || isEmpty(confirmOperation.getCode())) {
            throw new InvalidInputData("Invalid input data operationId or verification code", 0);
        }
        return repository.saveConfirmOperation(confirmOperation);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
