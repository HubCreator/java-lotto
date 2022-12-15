package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Status;
import lotto.dto.input.InputPurchaseAmountDto;
import lotto.view.IOViewResolver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class Controller {
    private final IOViewResolver ioViewResolver;
    private final Map<Status, Supplier<Status>> statusMap;

    public Controller(IOViewResolver ioViewResolver) {
        this.ioViewResolver = ioViewResolver;
        this.statusMap = new EnumMap<>(Status.class);
        initStatusMap();
    }

    public Status run(Status status) {
        try {
            return statusMap.get(status).get();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return status;
        }
    }

    private void initStatusMap() {
        statusMap.put(Status.INPUT_PURCHASE_AMOUNT, this::inputPurchaseAmount);
    }

    private Status inputPurchaseAmount() {
        InputPurchaseAmountDto inputPurchaseAmountDto = ioViewResolver.inputViewResolve(InputPurchaseAmountDto.class);
        Lotto lotto = Lotto.create(inputPurchaseAmountDto.getPurchaseAmount());
        return null;
    }
}
