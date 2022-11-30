package lotto.enums;

public enum ResultMessage {
    DECIMAL_FORMAT("#,###.0%"),
    MESSAGE_FORMAT("{0}개 일치 ({1}원) - {2}개\n"),
    BONUS_BALL_MESSAGE_FORMAT("{0}개 일치, 보너스 볼 일치 ({1}원) - {2}개\n");

    private final String value;

    ResultMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
