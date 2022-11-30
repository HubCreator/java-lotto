package lotto;

import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Lottos generatedLottos = purchaseLotto();
            WinLotto winLotto = getWinLotto();
            Result result = winLotto.getResult(generatedLottos);

            OutputView.print(result.getStatistics());
            OutputView.print(result.getAvenue());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

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
