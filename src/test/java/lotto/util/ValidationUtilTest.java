package lotto.util;

import lotto.domain.Lotto;
import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


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

    @DisplayName("입력된 금액이 1000원 단위인지 확인한다.")
    @Nested
    class ValidLottos {

        @DisplayName("1000원 단위의 입력은 통과")
        @ParameterizedTest
        @ValueSource(strings = {"1000", "2000", "12000"})
        void case1(String value) {
            assertThatCode(() -> ValidationUtil.isValidAmount(value))
                    .doesNotThrowAnyException();
        }

        @DisplayName("1000원 단위의 입력이 아니면 에러 발생")
        @ParameterizedTest
        @ValueSource(strings = {"100", "999", "1001"})
        void case2(String value) {
            assertThatThrownBy(() -> ValidationUtil.isValidAmount(value))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NOT_VALID_AMOUNT.getValue());
        }
    }

    @DisplayName("당첨 번호를 입력 받을 때에는")
    @Nested
    class DescribeInputWinLottoNumbersTest {

        @Nested
        @DisplayName("쉼표(,) 단위로 6개의 숫자를 받으면")
        class ContextWithValidDelimiterAndSizeTest {

            @Test
            @DisplayName("예외가 발생하지 않는다.")
            void it_returns_lottos() {
                assertThatCode(() -> ValidationUtil.isValidLottoNumbers("1,2,3,4,5,6"))
                        .doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("쉼표(,) 단위로 6개의 숫자를 받지 않으면")
        class ContextWithInValidDelimiterAndSizeTest {

            @DisplayName("예외가 발생한다.")
            @ParameterizedTest
            @ValueSource(strings = {"1,2,3,4,5", "1", "1,2,,", "11234", "1*,2:3"})
            void it_returns_exception(String value) {
                assertThatThrownBy(() -> ValidationUtil.isValidLottoNumbers(value))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.NOT_VALID_NUMBERS.getValue());
            }
        }
    }

    @DisplayName("보너스 번호를 ")
    @Nested
    class DescribeInputWinBonusNumbersTest {

        Lotto lotto;

        @BeforeEach
        void init() {
            lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        }

        @Nested
        @DisplayName("입력 받을 때에는")
        class ContextWithNotDigitTest {

            @DisplayName("입력 유효 범위를 초과하면 예외가 발생한다.")
            @ParameterizedTest
            @ValueSource(strings = {"-1", "0", "46"})
            void it_returns_exception1(String value) {
                assertThatThrownBy(() -> ValidationUtil.isValidBonusNumber(lotto, value))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.OUT_OF_BOUNDS_ERROR.getValue());
            }

            @DisplayName("숫자가 아닌 문자가 입력되면 예외가 발생한다.")
            @ParameterizedTest
            @ValueSource(strings = {"*", "!"})
            void it_returns_exception2(String value) {
                assertThatThrownBy(() -> ValidationUtil.isValidBonusNumber(lotto, value))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.IS_NOT_DIGIT.getValue());
            }
        }
    }
}