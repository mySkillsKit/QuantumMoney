package ru.netology.quantummoney.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.quantummoney.model.ConfirmOperation;
import ru.netology.quantummoney.model.MoneyTransfer;
import ru.netology.quantummoney.model.SuccessResponse;
import ru.netology.quantummoney.service.MoneyTransferService;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "https://serp-ya.github.io", methods = RequestMethod.POST)
public class MoneyTransferController {
    private final MoneyTransferService service;

    public MoneyTransferController(MoneyTransferService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public SuccessResponse saveMoneyTransfer(@Valid @RequestBody MoneyTransfer transfer) {
        return service.saveMoneyTransfer(transfer);
    }

    @PostMapping("/confirmOperation")
    public SuccessResponse saveConfirmOperation(@Valid @RequestBody ConfirmOperation confirmOperation) {
        return service.saveConfirmOperation(confirmOperation);
    }


}
