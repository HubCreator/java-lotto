package lotto.domain;

import lotto.enums.ConstVariable;
import lotto.enums.ErrorMessage;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Lotto implements Iterable<Integer> {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!ConstVariable.SIZE.isMatch(numbers.size())) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_MATCH_SIZE.getValue());
        }
        isNotDistinct(numbers);
    }

    private void isNotDistinct(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_DISTINCT.getValue());
        }
    }

    // TODO: 추가 기능 구현
    public void sortNumbers() {
        Collections.sort(numbers);
    }

    public boolean contains(int value) {
        return numbers.contains(value);
    }

    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
