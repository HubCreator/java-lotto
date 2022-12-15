package lotto.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WinLottoTest {

    @Test
    void 중복된_보너스_번호_입력() {
        assertThatThrownBy(() -> WinLotto.create(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 중복되지_않는_보너스_번호_입력() {
        assertThatCode(() -> WinLotto.create(List.of(1, 2, 3, 4, 5, 6), 7))
                .doesNotThrowAnyException();
    }
}