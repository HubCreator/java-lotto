package lotto.util;

import lotto.enums.ConstVariable;
import lotto.enums.ErrorMessage;

import java.util.StringTokenizer;

public class ValidationUtil {

    public static void isValidRange(int value) {
        if (ConstVariable.MIN.isLessThan(value) || ConstVariable.MAX.isGreaterThan(value)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_BOUNDS_ERROR.getValue());
        }
    }

    public static int isValidAmount(int value) {
        if (!ConstVariable.isValidAmount(value)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_AMOUNT.getValue());
        }
        return value / ConstVariable.UNIT.getValue();
    }

    public static void isValidLottoNumbers(String input) {
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
        if (!ConstVariable.SIZE.isMatch(stringTokenizer.countTokens())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_NUMBERS.getValue());
        }
    }
}
