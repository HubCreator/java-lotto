package lotto.domain;

import lotto.util.ValidationUtil;

import java.util.List;

public class WinLotto extends Lotto {
    private final int bonusNumber;

    public WinLotto(List<Integer> winNumbers, int bonusNumber) {
        super(winNumbers);
        ValidationUtil.isValidBonusNumber(this, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Result getResult(Lottos generatedLottos) {
        return new Result(this, generatedLottos);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
