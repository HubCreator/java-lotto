package lotto.domain;

import java.util.List;

public class WinLotto extends Lotto {
    private final int bonusNumber;

    private WinLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinLotto create(List<Integer> winLotto, int bonusNumber) {
        validateDistinctBonusNumber(winLotto, bonusNumber);
        return new WinLotto(winLotto, bonusNumber);
    }

    private static void validateDistinctBonusNumber(List<Integer> winLotto, int bonusNumber) {
        if (winLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.message);
        }
    }

    private enum ErrorMessage {
        INVALID_BONUS_NUMBER("보너스 번호는 로또 번호와 중복되지 않아야 합니다.");

        private static final String errorHead = "[ERROR] ";

        private final String message;

        ErrorMessage(String message) {
            this.message = errorHead + message;
        }
    }
}
