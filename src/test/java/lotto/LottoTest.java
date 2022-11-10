package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_COUNT.getValue());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.HAVE_DUPLICATED_NUMBER.getValue());
    }

    @DisplayName("로또 번호가 1~45 이내의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 30, 40, 42, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER.getValue());
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumber() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 6), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_BONUS_NUMBER.getValue());
    }

    @DisplayName("자동으로 로또 번호를 생성한다.")
    @RepeatedTest(10)
    void createLotto() {
        Lotto generatedLotto = Lotto.create();
        List<Integer> numbers = generatedLotto.getNumbers();
        assertThat(numbers.size()).isEqualTo(6);
        for (Integer number : numbers) {
            assertThat(number).isGreaterThan(0).isLessThan(46);
        }
    }

    @DisplayName("하나의 로또 번호에 대한 당첨 내역을 출력한다.")
    @Nested
    class getSingleResult {

        @DisplayName("6개 일치")
        @Test
        void match6() {
            WinLotto winLotto = new WinLotto(List.of(1, 2, 4, 3, 5, 6), 7);
            Lotto generatedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Result result = winLotto.getResult(generatedLotto);
            assertThat(result).isEqualTo(new Result(6, false));
        }

        @DisplayName("5개 일치")
        @Test
        void match5() {
            WinLotto winLotto = new WinLotto(List.of(1, 2, 4, 3, 5, 6), 7);
            Lotto generatedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
            Result result = winLotto.getResult(generatedLotto);
            assertThat(result).isEqualTo(new Result(5, false));
        }

        @DisplayName("5개 일치 & 보너스볼 일치")
        @Test
        void match5AndMatchBonusBall() {
            WinLotto winLotto = new WinLotto(List.of(1, 2, 4, 3, 5, 6), 7);
            Lotto generatedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            Result result = winLotto.getResult(generatedLotto);
            assertThat(result).isEqualTo(new Result(5, true));
        }

        @DisplayName("4개 일치")
        @Test
        void match4() {
            WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 6), 7);
            Lotto generatedLotto = new Lotto(List.of(1, 2, 3, 4, 40, 41));
            Result result = winLotto.getResult(generatedLotto);
            assertThat(result).isEqualTo(new Result(4, false));
        }

        @DisplayName("3개 일치")
        @Test
        void match3() {
            WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 6), 7);
            Lotto generatedLotto = new Lotto(List.of(1, 2, 3, 40, 41, 45));
            Result result = winLotto.getResult(generatedLotto);
            assertThat(result).isEqualTo(new Result(3, false));
        }
    }

}
