package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    MATCH0(0, 0, false),
    MATCH3(3, 5_000, false),
    MATCH4(4, 50_000, false),
    MATCH5(5, 1_500_000, false),
    MATCH5_BONUS(5, 30_000_000, true),
    MATCH6(6, 2_000_000_000, false);

    private final long count;
    private final int amount;
    private final boolean bonusNumber;

    Rank(long count, int amount, boolean bonusNumber) {
        this.count = count;
        this.amount = amount;
        this.bonusNumber = bonusNumber;
    }

    public static Rank map(long count, boolean hasBonusNumber) {
        Optional<Rank> rank = Arrays.stream(Rank.values())
                .filter(m -> m.count == count && m.bonusNumber == hasBonusNumber)
                .findFirst();
        return rank.orElse(MATCH0);
    }

    public int getAmount() {
        return amount;
    }
}
