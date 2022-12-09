package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @DisplayName("발행된 로또 번호 하나가 당첨되는 경우를 테스트")
    @Nested
    class WinOneLotto {
        Result result;
        WinLotto winLotto;

        @BeforeEach
        void init() {
            winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        }

        @DisplayName("1등")
        @Test
        void case1() {
            result = new Result(winLotto, new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))));
            result.getStatistics();
            assertThat(result.getRevenue()).isEqualTo("총 수익률은 200,000,000.0%입니다.");
        }

        @DisplayName("2등")
        @Test
        void case2() {
            result = new Result(winLotto, new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)))));
            result.getStatistics();
            assertThat(result.getRevenue()).isEqualTo("총 수익률은 3,000,000.0%입니다.");
        }

        @DisplayName("3등")
        @Test
        void case3() {
            result = new Result(winLotto, new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)))));
            result.getStatistics();
            assertThat(result.getRevenue()).isEqualTo("총 수익률은 150,000.0%입니다.");
        }

        @DisplayName("4등")
        @Test
        void case4() {
            result = new Result(winLotto, new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)))));
            result.getStatistics();
            assertThat(result.getRevenue()).isEqualTo("총 수익률은 5,000.0%입니다.");
        }

        @DisplayName("5등")
        @Test
        void case5() {
            result = new Result(winLotto, new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)))));
            result.getStatistics();
            assertThat(result.getRevenue()).isEqualTo("총 수익률은 500.0%입니다.");
        }
    }

}