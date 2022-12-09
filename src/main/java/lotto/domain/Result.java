package lotto.domain;

import lotto.enums.ConstVariable;
import lotto.enums.ResultStatus;
import lotto.enums.ViewMessage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    public static final int INITIAL_COUNT = 0;

    private final DecimalFormat decimalFormat = new DecimalFormat(ResultMessage.DECIMAL_FORMAT.value);
    private final Map<ResultStatus, Integer> result;
    private final float purchaseAmount;
    private BigDecimal totalAmount = BigDecimal.ZERO;


    public Result(WinLotto winLotto, Lottos generatedLottos) {
        result = new LinkedHashMap<>();
        initMap();
        for (Lotto generatedLotto : generatedLottos) {
            ResultStatus status = ResultStatus.getStatus(winLotto, generatedLotto);
            result.put(status, result.get(status) + 1);
        }
        this.purchaseAmount = generatedLottos.size() * ConstVariable.UNIT.getValue();
    }

    private void initMap() {
        result.put(ResultStatus.FIFTH, INITIAL_COUNT);
        result.put(ResultStatus.FOURTH, INITIAL_COUNT);
        result.put(ResultStatus.THIRD, INITIAL_COUNT);
        result.put(ResultStatus.SECOND, INITIAL_COUNT);
        result.put(ResultStatus.FIRST, INITIAL_COUNT);
        result.put(ResultStatus.NONE, INITIAL_COUNT);
    }

    public String getStatistics() {
        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<ResultStatus, Integer> entry : result.entrySet()) {
            if (entry.getKey() == ResultStatus.NONE) {
                break;
            }
            buffer.append(getResult(entry.getKey(), entry.getValue()));
        }
        return buffer.toString();
    }

    private String getResult(ResultStatus key, int value) {
        if (value > 0) {
            totalAmount = totalAmount.add(BigDecimal.valueOf(key.getPrice()));
        }
        if (ResultStatus.SECOND.isMatch(key)) {
            return MessageFormat.format(ResultMessage.BONUS_BALL_MESSAGE_FORMAT.value,
                    key.getCount(), key.getPrice(), value);
        }
        return MessageFormat.format(ResultMessage.MESSAGE_FORMAT.value,
                key.getCount(), key.getPrice(), value);
    }

    public String getRevenue() {
        BigDecimal result = totalAmount.divide(BigDecimal.valueOf(purchaseAmount))
                .setScale(3, RoundingMode.HALF_EVEN);
        return MessageFormat.format(ViewMessage.OUTPUT_TOTAL_REVENUE.getValue(), decimalFormat.format(result));
    }

    private enum ResultMessage {
        DECIMAL_FORMAT("#,##0.0%"),
        MESSAGE_FORMAT("{0}개 일치 ({1}원) - {2}개\n"),
        BONUS_BALL_MESSAGE_FORMAT("{0}개 일치, 보너스 볼 일치 ({1}원) - {2}개\n");

        private final String value;

        ResultMessage(String value) {
            this.value = value;
        }
    }
}
