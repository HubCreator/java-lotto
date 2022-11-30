package lotto.domain;

import lotto.enums.ConstVariable;
import lotto.enums.ErrorMessage;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (ConstVariable.SIZE.isMatch(numbers.size())) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_MATCH_SIZE.getValue());
        }
    }

    // TODO: 추가 기능 구현
    public void sortNumbers() {
        Collections.sort(numbers);
    }
}
