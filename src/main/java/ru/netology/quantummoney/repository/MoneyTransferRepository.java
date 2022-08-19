package ru.netology.quantummoney.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.netology.quantummoney.exception.InvalidInputData;
import ru.netology.quantummoney.model.ConfirmOperation;
import ru.netology.quantummoney.model.MoneyTransfer;
import ru.netology.quantummoney.model.StatusMoneyTransfer;
import ru.netology.quantummoney.model.SuccessResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
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

    public SuccessResponse saveMoneyTransfer(MoneyTransfer transfer) {
        long id = countMoneyTransfer.incrementAndGet();
        transfer.setId(id);
        transfer.setStatusMoneyTransfer(StatusMoneyTransfer.CREATED);
        moneyTransferMap.put(id, transfer);
        String operationId = Long.toString(id);
        log.info("Money Transfer successful {} operationId = {}",
                transfer.getStatusMoneyTransfer(), operationId);
        return new SuccessResponse(operationId);
    }


    public SuccessResponse saveConfirmOperation(ConfirmOperation confirmOperation) {
        long id = Long.parseLong(confirmOperation.getOperationId());
        if (!moneyTransferMap.containsKey(id)) {
            throw new InvalidInputData("Not found operationId", id);
        } else {
            for (MoneyTransfer transfer : moneyTransferMap.values()) {
                if (transfer.getId() == id) {
                    if (transfer.getConfirmOperation() == null) {
                        confirmOperation.setTransferFee(transfer.getAmount().getValue() * 0.01);
                        transfer.setConfirmOperation(confirmOperation);
                        transfer.setStatusMoneyTransfer(StatusMoneyTransfer.CONFIRMED);
                        moneyTransferMap.put(id, transfer);
                        log.info("Money Transfer successful {}, Transfer:{} Commission:{}",
                                transfer.getStatusMoneyTransfer(),
                                transfer, transfer.getConfirmOperation().getTransferFee());
                        break;
                    } else {
                        throw new InvalidInputData("The transfer has already been confirmed", id);
                    }
                }
            }
        }
        return new SuccessResponse(Long.toString(id));
    }
}
