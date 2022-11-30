package lotto.enums;

public enum ErrorMessage {
    OUT_OF_BOUNDS_ERROR("범위를 초과한 입력입니다."),
    IS_NOT_MATCH_SIZE("6개의 숫자를 입력해야 합니다."),
    IS_NOT_DIGIT("숫자를 입력해야 합니다."),
    IS_NOT_DISTINCT("중복된 숫자를 입력하면 안됩니다."),
    NOT_VALID_AMOUNT("1000원 단위로 입력해야 합니다."),
    NOT_VALID_NUMBERS("번호는 쉼표(,)를 기준으로 입력되어야 합니다."),
    NOT_VALID_BONUS_NUMBER("보너스 번호는 기존의 값과 중복되어선 안됩니다.");

    private static final String errorHead = "[ERROR] ";
    private final String value;

    ErrorMessage(String value) {
        this.value = errorHead + value;
    }

    public String getValue() {
        return value;
    }
}
