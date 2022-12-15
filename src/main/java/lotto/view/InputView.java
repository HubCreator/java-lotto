package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.input.InputBonusNumber;
import lotto.dto.input.InputPurchaseAmountDto;
import lotto.dto.input.InputWinLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputView {
    private InputView() {
    }

    private static class InputViewSingletonHelper {
        private static final InputView INPUT_VIEW = new InputView();
    }

    public static InputView getInstance() {
        return InputViewSingletonHelper.INPUT_VIEW;
    }

    public InputPurchaseAmountDto inputPurchaseAmount() {
        printMessage(ViewMessage.INPUT_PURCHASE_AMOUNT);
        int result = validateDigit(readUserInput());
        return new InputPurchaseAmountDto(result);
    }

    public InputWinLotto inputWinLotto() {
        printMessage(ViewMessage.INPUT_WIN_LOTTO);
        String input = readUserInput();
        return new InputWinLotto(validateWinLotto(input));
    }

    public InputBonusNumber inputBonusNumber() {
        printMessage(ViewMessage.INPUT_BONUS_NUMBER);
        String input = readUserInput();
        return new InputBonusNumber(validateDigit(input));
    }

    private List<Integer> validateWinLotto(String input) {
        return Arrays.stream(input.split(","))
                .map(this::validateDigit)
                .collect(Collectors.toList());
    }

    private int validateDigit(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIGIT.message, exception);
        }
    }

    private String readUserInput() {
        return Console.readLine();
    }

    private void printMessage(ViewMessage viewMessage) {
        System.out.println(viewMessage.message);
    }

    private enum ViewMessage {
        INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
        INPUT_WIN_LOTTO("당첨 번호를 입력해 주세요."),
        INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        ViewMessage(String message) {
            this.message = message;
        }
    }

    private enum ErrorMessage {
        NOT_DIGIT("숫자를 입력해야 합니다.");

        private static final String errorHead = "[ERROR] ";

        private final String message;

        ErrorMessage(String message) {
            this.message = errorHead + message;
        }
    }
}
