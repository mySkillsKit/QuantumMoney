package ru.netology.quantummoney;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.quantummoney.model.Amount;
import ru.netology.quantummoney.model.ConfirmOperation;
import ru.netology.quantummoney.model.MoneyTransfer;
import ru.netology.quantummoney.model.SuccessResponse;
import ru.netology.quantummoney.repository.MoneyTransferRepository;
import ru.netology.quantummoney.service.MoneyTransferService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MoneyTransferServiceMockTest {

    @Mock
    private MoneyTransferRepository repository;

    @InjectMocks
    private MoneyTransferService service;

    @Test
    void testSaveMoneyTransfer() {

        MoneyTransfer transfer = new MoneyTransfer(
                "1115666600101892",
                "05/23",
                "530",
                "5555636200001111",
                new Amount(67899, "RUB")
        );

        SuccessResponse response = new SuccessResponse("1");

        when(repository.saveMoneyTransfer(transfer)).thenReturn(response);

        assertEquals(response, service.saveMoneyTransfer(transfer));

    }

    @Test
    void testSaveConfirmOperation() {
        ConfirmOperation request = new ConfirmOperation("10", "3636");
        SuccessResponse response = new SuccessResponse("10");

        when(repository.saveConfirmOperation(request)).thenReturn(response);

        assertEquals(response, service.saveConfirmOperation(request));

    }

}

