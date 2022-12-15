package lotto.util;

import java.util.List;

@FunctionalInterface
public interface RandomNumberGenerator {
    List<Integer> generate(int min, int max, int count);
}
