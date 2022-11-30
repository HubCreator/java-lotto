package lotto.domain;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinLottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.IS_NOT_MATCH_SIZE.getValue());
    }

    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    public void createLottoByLessSize() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.IS_NOT_MATCH_SIZE.getValue());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 5), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.IS_NOT_DISTINCT.getValue());
    }

    @DisplayName("보너스 번호가 기존의 숫자와 중복되면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_VALID_BONUS_NUMBER.getValue());
    }
}