package lotto.domain;

import lotto.util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int COUNT = 6;

    protected final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validate(numbers);
    }

    public static Lotto create(RandomNumberGenerator numbers) {
        return new Lotto(numbers.generate());
    }

    public boolean contain(int number) {
        return numbers.contains(number);
    }


    private List<Integer> validate(List<Integer> numbers) {
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
        INVALID_COUNT("%d자리 숫자를 입력해야 합니다.", COUNT);

        private final String message;

        ErrorMessage(String message, Object... replaces) {
            this.message = String.format(message, replaces);
        }
    }
}
