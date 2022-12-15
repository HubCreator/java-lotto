package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

public class ResultInformation {

    private static final DecimalFormat decimalFormat = new DecimalFormat("###,##0.0");

    private final Map<Rank, Integer> statistics;
    private final int lottoCount;
    private final String profit;

    public ResultInformation(Map<Rank, Integer> statistics, int lottoCount) {
        this.statistics = statistics;
        this.lottoCount = lottoCount;
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
        BigDecimal divide = result.divide(BigDecimal.valueOf(lottoCount), RoundingMode.HALF_EVEN);
        return decimalFormat.format(divide.multiply(BigDecimal.valueOf(100)));
    }

    public Map<Rank, Integer> getStatistics() {
        return statistics;
    }

    public String getProfit() {
        return profit;
    }
}
