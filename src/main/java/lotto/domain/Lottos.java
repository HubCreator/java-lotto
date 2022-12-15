package lotto.domain;

import lotto.enums.ConstVariable;
import lotto.enums.ErrorMessage;
import lotto.util.GenerateRandomNumberUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(int amount) {
        int count = validateAmount(amount);
        List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            lottos.add(GenerateRandomNumberUtil.generateLotto());
        }
        return new Lottos(lottos);
    }

    private static int validateAmount(int amount) {
        if (!ConstVariable.isValidAmount(amount)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_AMOUNT.getValue());
        }
        return amount / ConstVariable.UNIT.getValue();
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
