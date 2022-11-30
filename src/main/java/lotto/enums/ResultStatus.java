package lotto.enums;

public enum ResultStatus {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE1(2, 0, false),
    NONE2(1, 0, false),
    NONE3(0, 0, false);
    
    private final int count;
    private final int price;
    private final boolean hasbonusNumber;

    ResultStatus(int count, int price, boolean hasbonusNumber) {
        this.count = count;
        this.price = price;
        this.hasbonusNumber = hasbonusNumber;
    }
}
