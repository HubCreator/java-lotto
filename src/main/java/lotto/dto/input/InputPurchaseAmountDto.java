package lotto.dto.input;

public final class InputPurchaseAmountDto {
    private final int purchaseAmount;

    public InputPurchaseAmountDto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
