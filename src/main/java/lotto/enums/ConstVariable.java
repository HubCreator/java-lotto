package lotto.enums;

public enum ConstVariable {
    MIN(1), MAX(45), SIZE(6), UNIT(1000);

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

    public static boolean isValidAmount(int value) {
        return value % UNIT.value == 0;
    }
}
