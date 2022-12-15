package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class StandardRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public List<Integer> generate(int min, int max, int count) {
        return Randoms.pickUniqueNumbersInRange(min, max, count);
    }
}
