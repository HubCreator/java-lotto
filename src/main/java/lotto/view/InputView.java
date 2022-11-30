package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ValidationUtil;

public class InputView {
    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount = ValidationUtil.isValidAmount(input);
        System.out.println(String.format("%d개를 구매했습니다.", amount));
        return amount;
    }
}
