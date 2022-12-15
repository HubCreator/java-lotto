package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validateSize(numbers);
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private List<Integer> validateSize(List<Integer> numbers) {
        List<Integer> result = numbers.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        if (result.size() != COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.message);
        }
        return result;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private enum ErrorMessage {
        INVALID_UNIT("1000 단위로 입력해야 합니다."),
        INVALID_COUNT("6자리 숫자를 입력해야 합니다.");

        private static final String errorHead = "[ERROR] ";

        private final String message;

        ErrorMessage(String message) {
            this.message = errorHead +  message;
        }
    }

}
