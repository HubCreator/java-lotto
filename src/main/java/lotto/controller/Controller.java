package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Status;
import lotto.dto.input.InputPurchaseAmountDto;
import lotto.dto.output.PrintGeneratedLottosDto;
import lotto.util.RandomNumberGenerator;
import lotto.view.IOViewResolver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class Controller {

    private final IOViewResolver ioViewResolver;
    private final Map<Status, Supplier<Status>> statusMap;

    public Controller(IOViewResolver ioViewResolver, RandomNumberGenerator generator) {
        this.ioViewResolver = ioViewResolver;
        this.statusMap = new EnumMap<>(Status.class);
        initStatusMap(generator);
    }

    private void initStatusMap(RandomNumberGenerator generator) {
        statusMap.put(Status.INPUT_PURCHASE_AMOUNT, () -> inputPurchaseAmount(generator));
    }

    public Status run(Status status) {
        try {
            return statusMap.get(status).get();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return status;
        }
    }

    private Status inputPurchaseAmount(RandomNumberGenerator generator) {
        InputPurchaseAmountDto inputPurchaseAmountDto = ioViewResolver.inputViewResolve(InputPurchaseAmountDto.class);
        Lottos lottos = Lottos.create(inputPurchaseAmountDto.getPurchaseAmount(), generator);
        ioViewResolver.outputViewResolve(new PrintGeneratedLottosDto(lottos));
        return null;
    }
}
