package lotto.util;

import lotto.domain.Lotto;
import lotto.enums.ConstVariable;
import lotto.enums.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ValidationUtil {

    public static void isValidRange(int value) {
        if (ConstVariable.MIN.isLessThan(value) || ConstVariable.MAX.isGreaterThan(value)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_BOUNDS_ERROR.getValue());
        }
    }

    public static int isDigit(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_DIGIT.getValue());
        }
    }

    public static List<Integer> isValidLottoNumbers(String input) {
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
        if (!ConstVariable.SIZE.isMatch(stringTokenizer.countTokens())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_NUMBERS.getValue());
        }
        List<Integer> result = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            int token = isDigit(stringTokenizer.nextToken());
            isValidRange(token);
            result.add(token);
        }
        return result;
    }

    public static int isValidBonusNumber(Lotto lotto, String bonusNumber) {
        int value = isDigit(bonusNumber);
        isValidRange(value);
        if (lotto.contains(value)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_BONUS_NUMBER.getValue());
        }
        return value;
    }

    public static int isValidBonusNumber(Lotto lotto, int bonusNumber) {
        isValidRange(bonusNumber);
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_BONUS_NUMBER.getValue());
        }
        return bonusNumber;
    }
}
