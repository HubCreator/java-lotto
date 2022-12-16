package lotto.domain;

import lotto.util.RandomNumberGenerator;

import java.util.Arrays;
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
        Map<Rank, Integer> resultMap = new EnumMap<>(Rank.class);
        initMap(resultMap);
        for (Lotto generatedLotto : generatedLottos) {
            Rank rank = getRank(generatedLotto);
            resultMap.put(rank, resultMap.get(rank) + 1);
        }
        return resultMap;
    }

    private void initMap(Map<Rank, Integer> result) {
        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, 0));
    }

    private Rank getRank(Lotto generatedLotto) {
        int count = winLotto.matchCount(generatedLotto);
        boolean hasBonusNumber = winLotto.hasBonusNumber(generatedLotto);
        return Rank.map(count, hasBonusNumber);
    }
}
