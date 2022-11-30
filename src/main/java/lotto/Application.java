package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.GenerateRandomNumberUtil;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int amount = InputView.readPurchaseAmount();
        Lottos lottos = getLottos(amount);
        List<Integer> winNumbers = InputView.readWinNumbers();
        int bonusNumber = InputView.readWinBonusNumber(winNumbers);

    }

    private static Lottos getLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < amount; index++) {
            lottos.add(GenerateRandomNumberUtil.generateLotto());
        }
        return new Lottos(lottos);
    }
}
