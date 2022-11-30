package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ValidationUtil;

public class InputView {
    public static void readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        ValidationUtil.isValidAmount(input);
    }
}
