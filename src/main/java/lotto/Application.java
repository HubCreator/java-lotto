package lotto;

import lotto.domain.Lottos;
import lotto.domain.WinLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Lottos generatedLottos = purchaseLotto();
        WinLotto winLotto = getWinLotto();
        winLotto.getResult(generatedLottos);
    }

    private static Lottos purchaseLotto() {
        int amount = InputView.readPurchaseAmount();
        Lottos lottos = Lottos.create(amount);
        OutputView.printPurchaseAmount(lottos);
        return lottos;
    }

    private static WinLotto getWinLotto() {
        List<Integer> winNumbers = InputView.readWinNumbers();
        int bonusNumber = InputView.readWinBonusNumber(winNumbers);
        return new WinLotto(winNumbers, bonusNumber);
    }
}
