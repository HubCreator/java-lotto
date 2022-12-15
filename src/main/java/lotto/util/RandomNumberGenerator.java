package lotto.util;

import java.util.List;

@FunctionalInterface
public interface RandomNumberGenerator {
    List<Integer> generate();
}
