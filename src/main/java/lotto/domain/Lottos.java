package lotto.domain;

import lotto.util.GenerateRandomNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < amount; index++) {
            lottos.add(GenerateRandomNumberUtil.generateLotto());
        }
        return new Lottos(lottos);
    }
}
