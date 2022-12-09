package lotto.enums;

import lotto.domain.Lotto;
import lotto.domain.WinLotto;

public enum ResultStatus {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(2, 0, false);

    private final int count;
    private final int price;
    private final boolean hasBonusNumber;

    ResultStatus(int count, int price, boolean hasBonusNumber) {
        this.count = count;
        this.price = price;
        this.hasBonusNumber = hasBonusNumber;
        String hello = String.format("%s", "dkssud");
    }

    public static ResultStatus getStatus(WinLotto winLotto, Lotto generatedLotto) {
        int count = countMatchedNumber(winLotto, generatedLotto);
        boolean hasBonusNumber = hasBonusNumber(winLotto, generatedLotto);
        for (ResultStatus value : ResultStatus.values()) {
            if (value.count == count && value.hasBonusNumber == hasBonusNumber) {
                return value;
            }
        }
        return NONE;
    }

    private static boolean hasBonusNumber(WinLotto winLotto, Lotto generatedLotto) {
        return winLotto.hasBonusNumber(generatedLotto);
    }

    private static int countMatchedNumber(WinLotto winLotto, Lotto generatedLotto) {
        int count = 0;
        for (Integer number : winLotto) {
            if (generatedLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean isMatch(ResultStatus status) {
        return this == status;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}
