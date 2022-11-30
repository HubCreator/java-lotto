package lotto.domain;

import lotto.enums.ResultStatus;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    public static final int INITIAL_COUNT = 0;
    public static final String messageFormat = "{0}개 일치 ({1}원) - {2}개\n";
    public static final String bonusBallMessageFormat = "{0}개 일치, 보너스 볼 일치 ({1}원) - {2}개\n";

    Map<ResultStatus, Integer> result = new LinkedHashMap<>();

    public Result(WinLotto winLotto, Lottos generatedLottos) {
        initMap();
        for (Lotto generatedLotto : generatedLottos) {
            ResultStatus status = ResultStatus.getStatus(winLotto, generatedLotto);
            result.put(status, result.get(status) + 1);
        }
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

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<ResultStatus, Integer> entry : result.entrySet()) {
            if (entry.getKey() == ResultStatus.NONE1) {
                break;
            }
            buffer.append(getResult(entry));
        }
        return buffer.toString();
    }

    private String getResult(Map.Entry<ResultStatus, Integer> entry) {
        ResultStatus key = entry.getKey();
        if (key == ResultStatus.FOURTH) {
            return MessageFormat.format(bonusBallMessageFormat, key.getCount(), key.getPrice(), entry.getValue());
        }
        return MessageFormat.format(messageFormat, key.getCount(), key.getPrice(), entry.getValue());
    }
}
