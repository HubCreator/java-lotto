package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("원하는 만큼의 로또를 발행할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 4, 5, 20, 100})
    void case1(int value) {
        assertThat(Lottos.create(value).size()).isSameAs(value);
    }
}