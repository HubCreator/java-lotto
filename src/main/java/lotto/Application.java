package lotto;

import lotto.domain.Lottos;
import lotto.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int amount = InputView.readPurchaseAmount();
        Lottos lottos = Lottos.create(amount);
        List<Integer> winNumbers = InputView.readWinNumbers();
        int bonusNumber = InputView.readWinBonusNumber(winNumbers);

    }


}
