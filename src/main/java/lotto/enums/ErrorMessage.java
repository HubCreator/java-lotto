package lotto.enums;

public enum ErrorMessage {
    OUT_OF_BOUNDS_ERROR("범위를 초과한 입력입니다.");

    private static final String errorHead = "[ERROR] ";
    private final String value;

    ErrorMessage(String value) {
        this.value = errorHead + value;
    }

    public String getValue() {
        return value;
    }
}
