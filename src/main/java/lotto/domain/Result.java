package lotto.domain;

import lotto.enums.ConstVariable;
import lotto.enums.ResultStatus;
import lotto.enums.ViewMessage;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    public static final int INITIAL_COUNT = 0;
    private final DecimalFormat decimalFormat = new DecimalFormat("#,###.0%");
    public static final String messageFormat = "{0}개 일치 ({1}원) - {2}개\n";
    public static final String bonusBallMessageFormat = "{0}개 일치, 보너스 볼 일치 ({1}원) - {2}개\n";

    private final Map<ResultStatus, Integer> result;
    private final float purchaseAmount;
    private float totalAmount = 0;


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
        result.put(ResultStatus.NONE1, INITIAL_COUNT);
        result.put(ResultStatus.NONE2, INITIAL_COUNT);
        result.put(ResultStatus.NONE3, INITIAL_COUNT);
    }

    public String getStatistics() {
        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<ResultStatus, Integer> entry : result.entrySet()) {
            if (entry.getKey() == ResultStatus.NONE1) {
                break;
            }
            buffer.append(getResult(entry.getKey(), entry.getValue()));
        }
        return buffer.toString();
    }

    private String getResult(ResultStatus key, int value) {
        if (value > 0) {
            totalAmount += key.getPrice();
        }
        if (key == ResultStatus.FOURTH) {
            return MessageFormat.format(bonusBallMessageFormat, key.getCount(), key.getPrice(), value);
        }
        return MessageFormat.format(messageFormat, key.getCount(), key.getPrice(), value);
    }

    public String getAvenue() {
        return MessageFormat.format(ViewMessage.OUTPUT_TOTAL_AVENUE.getValue(),
                decimalFormat.format(totalAmount / purchaseAmount));
    }
}
