package ru.netology.quantummoney.repository;

import org.springframework.stereotype.Repository;
import ru.netology.quantummoney.exception.ErrorTransferOrConfirm;
import ru.netology.quantummoney.model.ConfirmOperation;
import ru.netology.quantummoney.model.MoneyTransfer;
import ru.netology.quantummoney.model.SuccessResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MoneyTransferRepository {
    private final Map<Long, MoneyTransfer> moneyTransferMap = new ConcurrentHashMap<>();
    private final AtomicLong countMoneyTransfer = new AtomicLong(0);


    public List<MoneyTransfer> all() {
        return new ArrayList<>(moneyTransferMap.values());
    }

    public Optional<MoneyTransfer> getById(long id) {
        for (MoneyTransfer transfer : moneyTransferMap.values()) {
            if (transfer.getId() == id) {
                return Optional.of(transfer);
            }
        }
        return Optional.empty();
    }

    public SuccessResponse saveMoneyTransfer(MoneyTransfer moneyTransfer) {
        long id = countMoneyTransfer.incrementAndGet();
        moneyTransfer.setId(id);
        moneyTransferMap.put(id, moneyTransfer);
        String operationId = Long.toString(id);
        System.out.println(moneyTransferMap);
        return new SuccessResponse(operationId);
    }


    public SuccessResponse saveConfirmOperation(ConfirmOperation confirmOperation) {
        long id = Long.parseLong(confirmOperation.getOperationId());
        for (MoneyTransfer transfer : moneyTransferMap.values()) {
            if (transfer.getId() == id) {
                confirmOperation.setTransferFee(transfer.getAmount().getValue() * 0.01);
                transfer.setConfirmOperation(confirmOperation);
                moneyTransferMap.put(id, transfer);
                System.out.println(transfer);
                System.out.println(moneyTransferMap);
            } else {
                throw new ErrorTransferOrConfirm("Not found operationId", id);
            }
        }

        return new SuccessResponse(Long.toString(id));
    }
}
