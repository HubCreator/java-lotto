package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.util.ValidationUtil;

import java.util.List;

public class InputView {
    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return ValidationUtil.isValidAmount(input);
    }

    public static List<Integer> readWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return ValidationUtil.isValidLottoNumbers(input);
    }

    public static int readWinBonusNumber(List<Integer> winNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return ValidationUtil.isValidBonusNumber(new Lotto(winNumbers), input);
    }
}
