package lotto.view;

import lotto.dto.input.InputBonusNumber;
import lotto.dto.input.InputPurchaseAmountDto;
import lotto.dto.input.InputWinLotto;
import lotto.dto.output.PrintExceptionDto;
import lotto.dto.output.PrintGeneratedLottosDto;
import lotto.dto.output.PrintWinStatisticsDto;
import lotto.view.exception.NotFoundViewException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class IOViewResolver {

    private final Map<Class<?>, Supplier<Object>> inputViewMap = new HashMap<>();
    private final Map<Class<?>, Consumer<Object>> outputViewMap = new HashMap<>();

    public IOViewResolver(InputView inputView, OutputView outputView) {
        initInputViewMappings(inputView);
        initOutputViewMappings(outputView);
    }

    private void initInputViewMappings(InputView inputView) {
        inputViewMap.put(InputPurchaseAmountDto.class, inputView::inputPurchaseAmount);
        inputViewMap.put(InputWinLotto.class, inputView::inputWinLotto);
        inputViewMap.put(InputBonusNumber.class, inputView::inputBonusNumber);
    }

    private void initOutputViewMappings(OutputView outputView) {
        outputViewMap.put(PrintGeneratedLottosDto.class, dto -> outputView.printGeneratedLottos((PrintGeneratedLottosDto) dto));
        outputViewMap.put(PrintWinStatisticsDto.class, dto -> outputView.printWinStatistics((PrintWinStatisticsDto) dto));
        outputViewMap.put(PrintExceptionDto.class, dto -> outputView.printException((PrintExceptionDto) dto));
    }

    public <T> T inputViewResolve(final Class<T> type) {
        try {
            return type.cast(inputViewMap.get(type).get());
        } catch (NullPointerException e) {
            throw new NotFoundViewException();
        }
    }

    public void outputViewResolve(final Object dto) {
        try {
            outputViewMap.get(dto.getClass()).accept(dto);
        } catch (NullPointerException e) {
            throw new NotFoundViewException();
        }
    }
}
