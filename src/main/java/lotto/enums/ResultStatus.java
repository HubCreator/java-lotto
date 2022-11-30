package lotto.enums;

import lotto.domain.Lotto;
import lotto.domain.WinLotto;

public enum ResultStatus {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE1(2, 0, false),
    NONE2(1, 0, false),
    NONE3(0, 0, false);

    private final int count;
    private final int price;
    private final boolean hasbonusNumber;

    ResultStatus(int count, int price, boolean hasbonusNumber) {
        this.count = count;
        this.price = price;
        this.hasbonusNumber = hasbonusNumber;
    }

    public static ResultStatus getStatus(WinLotto winLotto, Lotto generatedLotto) {
        int count = countMatchedNumber(winLotto, generatedLotto);
        boolean hasBonusNumber = hasBonusNumber(winLotto, generatedLotto);
        for (ResultStatus value : ResultStatus.values()) {
            if (value.count == count && value.hasbonusNumber == hasBonusNumber) {
                return value;
            }
        }
        return NONE3;
    }

    private static boolean hasBonusNumber(WinLotto winLotto, Lotto generatedLotto) {
        return generatedLotto.contains(winLotto.getBonusNumber());
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

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}
