package lotto.domain;

import lotto.util.RandomNumberGenerator;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class LottoGame {

    private final Lottos generatedLottos;
    private WinLotto winLotto;
    private ResultInformation resultInformation;

    public LottoGame(int purchaseAmount, RandomNumberGenerator generator) {
        this.generatedLottos = Lottos.create(purchaseAmount, generator);
    }

    public Lottos getGeneratedLottos() {
        return generatedLottos;
    }

    public void addWinLotto(List<Integer> winLotto, int bonusNumber) {
        this.winLotto = WinLotto.create(winLotto, bonusNumber);
        this.resultInformation = new ResultInformation(calculateStatistics(), generatedLottos.getLottoCount());
    }

    public ResultInformation getResultInformation() {
        return resultInformation;
    }

    public Map<Rank, Integer> calculateStatistics() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Lotto generatedLotto : generatedLottos) {
            Rank rank = getRank(generatedLotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private Rank getRank(Lotto generatedLotto) {
        long count = winLotto.matchCount(generatedLotto);
        boolean hasBonusNumber = winLotto.hasBonusNumber(generatedLotto);
        return Rank.map(count, hasBonusNumber);
    }
}
