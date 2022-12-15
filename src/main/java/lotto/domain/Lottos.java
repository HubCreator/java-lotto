package lotto.domain;

import lotto.util.RandomNumberGenerator;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Lottos implements Iterable<Lotto>{

    private static final int UNIT = 1000;

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(int purchaseAmount, RandomNumberGenerator generator) {
        List<Lotto> result = IntStream.range(0, validateAmount(purchaseAmount))
                .mapToObj(m -> Lotto.create(generator))
                .collect(Collectors.toList());

        return new Lottos(result);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    private static int validateAmount(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT.message);
        }
        return amount / UNIT;
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

    private enum ErrorMessage {
        INVALID_UNIT("%d 단위로 입력해야 합니다.", UNIT),;

        private final String message;

        ErrorMessage(String message, Object... replaces) {
            this.message =  String.format(message, replaces);
        }
    }
}
