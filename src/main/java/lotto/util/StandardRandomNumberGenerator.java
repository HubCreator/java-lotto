package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class StandardRandomNumberGenerator implements RandomNumberGenerator {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT);
    }
}
