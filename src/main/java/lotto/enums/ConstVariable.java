package lotto.enums;

public enum ConstVariable {
    MIN(1), MAX(45), SIZE(6);

    private final int value;

    ConstVariable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isMatch(int value) {
        return this.value == value;
    }

    public boolean isGreaterThan(int value) {
        return this.value < value;
    }

    public boolean isLessThan(int value) {
        return this.value > value;
    }
}
