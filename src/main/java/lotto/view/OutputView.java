package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.enums.ViewMessage;

import java.text.MessageFormat;

public class OutputView {
    public static void printPurchaseAmount(Lottos lottos) {
        print(MessageFormat.format(ViewMessage.OUTPUT_PURCHASE_COUNT.getValue(), lottos.size()));

        for (Lotto lotto : lottos) {
            print(lotto);
        }
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(Lotto lotto) {
//        lotto.sortNumbers();
        System.out.println(lotto);
    }
}
