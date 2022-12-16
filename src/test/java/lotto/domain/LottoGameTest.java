package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoGameTest {

    LottoGame lottoGame;

    @BeforeEach
    void name() {
        lottoGame = new LottoGame(1000, () -> List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void _6개_맞춘_경우() {
        lottoGame.addWinLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        ResultInformation resultInformation = lottoGame.getResultInformation();
        assertEquals(resultInformation.getProfit(), "200,000,000.0%");
    }

    @Test
    void _5개와_보너스_번호를_맞춘_경우() {
        lottoGame.addWinLotto(List.of(1, 2, 3, 4, 5, 8), 6);
        ResultInformation resultInformation = lottoGame.getResultInformation();
        assertEquals(resultInformation.getProfit(), "3,000,000.0%");
    }

    @Test
    void _5개_맞춘_경우() {
        lottoGame.addWinLotto(List.of(1, 2, 3, 4, 5, 8), 7);
        ResultInformation resultInformation = lottoGame.getResultInformation();
        assertEquals(resultInformation.getProfit(), "150,000.0%");
    }

    @Test
    void _4개_맞춘_경우() {
        lottoGame.addWinLotto(List.of(1, 2, 3, 4, 8, 9), 7);
        ResultInformation resultInformation = lottoGame.getResultInformation();
        assertEquals(resultInformation.getProfit(), "5,000.0%");
    }

    @Test
    void _3개_맞춘_경우() {
        lottoGame.addWinLotto(List.of(1, 2, 3, 8, 9, 10), 7);
        ResultInformation resultInformation = lottoGame.getResultInformation();
        assertEquals(resultInformation.getProfit(), "500.0%");
    }

    @Test
    void _2개_맞춘_경우() {
        lottoGame.addWinLotto(List.of(1, 2, 8, 9, 10, 11), 7);
        ResultInformation resultInformation = lottoGame.getResultInformation();
        assertEquals(resultInformation.getProfit(), "0.0%");
    }

    @Test
    void _1개__맞춘_경우() {
        lottoGame.addWinLotto(List.of(1, 8, 9, 10, 11, 12), 7);
        ResultInformation resultInformation = lottoGame.getResultInformation();
        assertEquals(resultInformation.getProfit(), "0.0%");
    }

    @Test
    void _0개__맞춘_경우() {
        lottoGame.addWinLotto(List.of(8, 9, 10, 11, 12, 13), 7);
        ResultInformation resultInformation = lottoGame.getResultInformation();
        assertEquals(resultInformation.getProfit(), "0.0%");
    }
}