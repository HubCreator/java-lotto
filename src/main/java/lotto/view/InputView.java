package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ValidationUtil;

import java.util.List;

public class InputView {
    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount = ValidationUtil.isValidAmount(input);
        System.out.println(String.format("%d개를 구매했습니다.", amount));
        return amount;
    }

    public static List<Integer> readWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return ValidationUtil.isValidLottoNumbers(input);
    }

    public static int readWinBonusNumber(List<Integer> winNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return ValidationUtil.isValidBonusNumber(winNumbers, input);
    }
}
