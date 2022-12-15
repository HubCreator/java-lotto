package lotto.domain;

import lotto.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto>{

    private static final int UNIT = 1000;

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(int purchaseAmount, RandomNumberGenerator generator) {
        int count = validateAmount(purchaseAmount);
        List<Lotto> result = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            result.add(Lotto.create(generator));
        }
        return new Lottos(result);
    }

    private static int validateAmount(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT.message);
        }
        return amount / UNIT;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

    private enum ErrorMessage {
        INVALID_UNIT("1000 단위로 입력해야 합니다.");

        private static final String errorHead = "[ERROR] ";

        private final String message;

        ErrorMessage(String message) {
            this.message = errorHead + message;
        }
    }
}
