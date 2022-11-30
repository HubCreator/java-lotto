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
}
