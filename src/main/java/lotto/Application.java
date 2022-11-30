package lotto;

import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        purchaseLotto();
        List<Integer> winNumbers = InputView.readWinNumbers();
        int bonusNumber = InputView.readWinBonusNumber(winNumbers);

    }

    private static void purchaseLotto() {
        int amount = InputView.readPurchaseAmount();
        Lottos lottos = Lottos.create(amount);
        OutputView.printPurchaseAmount(lottos);
    }
}
