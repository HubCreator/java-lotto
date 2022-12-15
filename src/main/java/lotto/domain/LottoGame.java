package lotto.domain;

import lotto.util.RandomNumberGenerator;

import java.util.List;

public class LottoGame {

    private final Lottos generatedLottos;
    private WinLotto winLotto;

    public LottoGame(int purchaseAmount, RandomNumberGenerator generator) {
        this.generatedLottos = Lottos.create(purchaseAmount, generator);
    }

    public Lottos getGeneratedLottos() {
        return generatedLottos;
    }

    public void addWinLotto(List<Integer> winLotto, int bonusNumber) {
        this.winLotto = WinLotto.create(winLotto, bonusNumber);
    }
}
