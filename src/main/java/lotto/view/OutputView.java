package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;

public class OutputView {
    public static void printPurchaseAmount(Lottos lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos) {
            lotto.sortNumbers();
            System.out.println(lotto);
        }
    }

    public static void printResult(Result result) {
        System.out.println(result);
    }
}
