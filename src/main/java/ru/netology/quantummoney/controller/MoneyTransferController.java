package ru.netology.quantummoney.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.quantummoney.model.ConfirmOperation;
import ru.netology.quantummoney.model.MoneyTransfer;
import ru.netology.quantummoney.model.SuccessResponse;
import ru.netology.quantummoney.service.MoneyTransferService;

@RestController
public class MoneyTransferController {
    private final MoneyTransferService service;

    public MoneyTransferController(MoneyTransferService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public SuccessResponse saveMoneyTransfer(@RequestBody MoneyTransfer transfer) {
        return service.saveMoneyTransfer(transfer);
    }

    @PostMapping("/confirmOperation")
    public SuccessResponse saveConfirmOperation(@RequestBody ConfirmOperation confirmOperation) {
        return service.saveConfirmOperation(confirmOperation);
    }


}
