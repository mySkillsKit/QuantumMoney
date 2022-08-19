package ru.netology.quantummoney.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.netology.quantummoney.model.ConfirmOperation;
import ru.netology.quantummoney.model.MoneyTransfer;
import ru.netology.quantummoney.model.SuccessResponse;
import ru.netology.quantummoney.service.MoneyTransferService;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "https://serp-ya.github.io", methods = RequestMethod.POST)
public class MoneyTransferController {
    private final MoneyTransferService service;

    @Autowired
    public MoneyTransferController(MoneyTransferService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public SuccessResponse saveMoneyTransfer(@Valid @RequestBody MoneyTransfer transfer) {
        log.info("Creating new money transfer {}", transfer);
        return service.saveMoneyTransfer(transfer);
    }

    @PostMapping("/confirmOperation")
    public SuccessResponse saveConfirmOperation(@Valid @RequestBody ConfirmOperation confirmOperation) {
        log.info("Confirming operation money transfer {}", confirmOperation);
        return service.saveConfirmOperation(confirmOperation);
    }


}
