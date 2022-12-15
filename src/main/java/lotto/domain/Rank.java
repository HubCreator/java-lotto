package lotto.domain;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    MATCH0(0, 0, "{0}개 일치 ({1}원)", false),
    MATCH3(3, 5_000, "{0}개 일치 ({1}원)", false),
    MATCH4(4, 50_000, "{0}개 일치 ({1}원)", false),
    MATCH5(5, 1_500_000, "{0}개 일치 ({1}원)", false),
    MATCH5_BONUS(5, 30_000_000, "{0}개 일치, 보너스 볼 일치 ({1}원)", true),
    MATCH6(6, 2_000_000_000, "{0}개 일치 ({1}원)", false);

    private final int count;
    private final int amount;
    private final String message;
    private final boolean bonusNumber;

    Rank(int count, int amount, String message, boolean bonusNumber) {
        this.count = count;
        this.amount = amount;
        this.message = message;
        this.bonusNumber = bonusNumber;
    }

    public static Rank map(int count, boolean hasBonusNumber) {
        Optional<Rank> rank = Arrays.stream(values())
                .filter(m -> (m.count == count && m.bonusNumber == hasBonusNumber))
                .findFirst();
        return rank.orElse(MATCH0);
    }

    public int getAmount() {
        return amount;
    }

    public String getMessage() {
        return MessageFormat.format(message, count, amount);
    }
}
