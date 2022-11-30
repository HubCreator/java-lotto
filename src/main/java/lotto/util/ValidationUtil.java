package lotto.util;

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

    public static int isValidAmount(String input) {
        int value = isDigit(input);
        if (!ConstVariable.isValidAmount(value)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_AMOUNT.getValue());
        }
        return value / ConstVariable.UNIT.getValue();
    }

    private static int isDigit(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_AMOUNT.getValue());
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

    public static int isValidBonusNumber(List<Integer> winNumbers, String bonusNumber) {
        int value = isDigit(bonusNumber);
        if (winNumbers.contains(value)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_BONUS_NUMBER.getValue());
        }
        return value;
    }
}
