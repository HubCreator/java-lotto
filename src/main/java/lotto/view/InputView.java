package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.enums.ViewMessage;
import lotto.util.ValidationUtil;

import java.util.List;

public class InputView {
    public static int readPurchaseAmount() {
        printMessage(ViewMessage.INPUT_AMOUNT_MESSAGE);
        String input = Console.readLine();
        return ValidationUtil.isValidAmount(input);
    }

    public static List<Integer> readWinNumbers() {
        printMessage(ViewMessage.INPUT_WIN_LOTTO_NUMBERS);
        String input = Console.readLine();
        return ValidationUtil.isValidLottoNumbers(input);
    }

    public static int readWinBonusNumber(List<Integer> winNumbers) {
        printMessage(ViewMessage.INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        return ValidationUtil.isValidBonusNumber(new Lotto(winNumbers), input);
    }

    private static void printMessage(ViewMessage message) {
        System.out.println(message.getValue());
    }
}
