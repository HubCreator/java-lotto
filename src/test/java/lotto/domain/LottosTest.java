package lotto.domain;

import lotto.util.RandomNumberGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @Test
    void 올바르지_않은_단위_입력() {
        assertThatThrownBy(() -> Lottos.create(1001,
                        () -> List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "1000:1",
                    "2000:2",
                    "10000:10"
            }, delimiter = ':'
    )
    void 올바른_가격_입력(int purchaseAmount, int lottoCount) {
        Lottos lottos = Lottos.create(purchaseAmount,
                () -> List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottos.getLottoCount()).isSameAs(lottoCount);
    }
}