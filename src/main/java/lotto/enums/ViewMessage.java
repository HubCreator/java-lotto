package lotto.enums;

public enum ViewMessage {
    INPUT_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WIN_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_PURCHASE_COUNT("{0}개를 구매했습니다."),
    OUTPUT_TOTAL_AVENUE("총 수익률은 {0}입니다.");

    private final String value;

    ViewMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
