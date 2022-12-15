package lotto.dto.input;

import java.util.List;

public final class InputWinLotto {
    private final List<Integer> winLotto;

    public InputWinLotto(List<Integer> winLotto) {
        this.winLotto = winLotto;
    }

    public List<Integer> getWinLotto() {
        return winLotto;
    }
}
