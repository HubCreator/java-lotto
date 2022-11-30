package lotto.util;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class ValidationUtilTest {

    @DisplayName("유효한 범위의 숫자인지 확인한다.")
    @Nested
    class ValidRange {

        @DisplayName("유효 범위 내의 숫자인지 확인한다.")
        @ParameterizedTest
        @ValueSource(ints = {1, 45})
        void case1(int value) {
            assertThatCode(() -> ValidationUtil.isValidRange(value))
                    .doesNotThrowAnyException();
        }

        @DisplayName("유효 범위를 초과하는 숫자인지 확인한다.")
        @ParameterizedTest
        @ValueSource(ints = {0, 46})
        void case2(int value) {
            assertThatThrownBy(() -> ValidationUtil.isValidRange(value))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.OUT_OF_BOUNDS_ERROR.getValue());
        }
    }

    @DisplayName("중복되지 않은 6개의 로또 번호가 생성됐는지 확인한다.")
    @Nested
    class ValidLottos {

    }

}