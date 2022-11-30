package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.enums.ViewMessage;

import java.text.MessageFormat;

public class OutputView {
    public static void printPurchaseAmount(Lottos lottos) {
        print(MessageFormat.format(ViewMessage.OUTPUT_PURCHASE_COUNT.getValue(), lottos.size()));

        for (Lotto lotto : lottos) {
            lotto.sortNumbers();
            print(lotto);
        }
    }

    public static void printResult(Result result) {
        print(result);
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void print(Lotto lotto) {
        System.out.println(lotto);
    }

    private static void print(Result result) {
        System.out.println(result);
    }
}
