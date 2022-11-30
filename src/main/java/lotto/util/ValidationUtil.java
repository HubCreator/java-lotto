package lotto.util;

import lotto.enums.ConstVariable;
import lotto.enums.ErrorMessage;

public class ValidationUtil {

    public static void isValidRange(int value) {
        if (value < ConstVariable.MIN.getValue() || value > ConstVariable.MAX.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_BOUNDS_ERROR.getValue());
        }
    }
}
