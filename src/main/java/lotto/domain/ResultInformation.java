package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

public class ResultInformation {

    private static final int UNIT = 1000;
    private static final DecimalFormat decimalFormat = new DecimalFormat("###,##0.0%");

    private final Map<Rank, Integer> statistics;
    private final long puchasedLottoAmount;
    private final String profit;

    public ResultInformation(Map<Rank, Integer> statistics, int lottoCount) {
        this.statistics = statistics;
        this.puchasedLottoAmount = (long) lottoCount * UNIT;
        this.profit = calculateProfit();
    }

    private String calculateProfit() {
        BigDecimal result = BigDecimal.ZERO;
        for (Map.Entry<Rank, Integer> entry : statistics.entrySet()) {
            BigDecimal amount = BigDecimal.valueOf(entry.getKey().getAmount());
            BigDecimal count = BigDecimal.valueOf(entry.getValue());
            BigDecimal multiplied = amount.multiply(count);
            result = result.add(multiplied);
        }
        BigDecimal divide = result.divide(BigDecimal.valueOf(puchasedLottoAmount), 3, RoundingMode.HALF_DOWN);
        return decimalFormat.format(divide);
    }

    public Map<Rank, Integer> getStatistics() {
        return statistics;
    }

    public String getProfit() {
        return profit;
    }
}
