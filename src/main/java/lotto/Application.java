package lotto;

import lotto.domain.Lotto;
import lotto.util.GenerateRandomNumberUtil;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int amount = InputView.readPurchaseAmount();
        List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < amount; index++) {
            lottos.add(GenerateRandomNumberUtil.generateLotto());
        }

    }
}
