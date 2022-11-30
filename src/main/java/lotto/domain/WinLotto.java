package lotto.domain;

import java.util.List;

public class WinLotto extends Lotto {
    private final int bonusNumber;

    public WinLotto(List<Integer> winNumbers, int bonusNumber) {
        super(winNumbers);
        this.bonusNumber = bonusNumber;
    }

    public void getResult(Lottos generatedLottos) {

    }
}
