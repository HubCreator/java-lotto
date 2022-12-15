package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.Status;
import lotto.dto.input.InputBonusNumber;
import lotto.dto.input.InputPurchaseAmountDto;
import lotto.dto.input.InputWinLotto;
import lotto.dto.output.PrintExceptionDto;
import lotto.dto.output.PrintGeneratedLottosDto;
import lotto.dto.output.PrintWinStatisticsDto;
import lotto.util.RandomNumberGenerator;
import lotto.view.IOViewResolver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class Controller {

    private final IOViewResolver ioViewResolver;
    private final Map<Status, Supplier<Status>> statusMap;
    private LottoGame lottoGame;

    public Controller(IOViewResolver ioViewResolver, RandomNumberGenerator generator) {
        this.ioViewResolver = ioViewResolver;
        this.statusMap = new EnumMap<>(Status.class);
        initStatusMap(generator);
    }

    private void initStatusMap(RandomNumberGenerator generator) {
        statusMap.put(Status.INPUT_PURCHASE_AMOUNT, () -> inputPurchaseAmount(generator));
        statusMap.put(Status.INPUT_WIN_LOTTO_AND_BONUS_NUMBER, this::inputWinLotto);
        statusMap.put(Status.OUTPUT_WIN_STATISTICS, this::outputWinStatistics);
    }

    public Status run(Status status) {
        try {
            return statusMap.get(status).get();
        } catch (IllegalArgumentException exception) {
            ioViewResolver.outputViewResolve(new PrintExceptionDto(exception));
            return status;
        }
    }

    private Status inputPurchaseAmount(RandomNumberGenerator generator) {
        InputPurchaseAmountDto inputPurchaseAmountDto = ioViewResolver.inputViewResolve(InputPurchaseAmountDto.class);
        lottoGame = new LottoGame(inputPurchaseAmountDto.getPurchaseAmount(), generator);
        ioViewResolver.outputViewResolve(new PrintGeneratedLottosDto(lottoGame.getGeneratedLottos()));
        return Status.INPUT_WIN_LOTTO_AND_BONUS_NUMBER;
    }

    private Status inputWinLotto() {
        InputWinLotto inputWinLotto = ioViewResolver.inputViewResolve(InputWinLotto.class);
        InputBonusNumber inputBonusNumber = ioViewResolver.inputViewResolve(InputBonusNumber.class);
        lottoGame.addWinLotto(inputWinLotto.getWinLotto(), inputBonusNumber.getBonusNumber());
        return Status.OUTPUT_WIN_STATISTICS;
    }

    private Status outputWinStatistics() {
        ioViewResolver.outputViewResolve(new PrintWinStatisticsDto(lottoGame.getResultInformation()));
        return Status.EXIT;
    }
}
