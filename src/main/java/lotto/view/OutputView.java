package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.ResultInformation;
import lotto.dto.output.PrintExceptionDto;
import lotto.dto.output.PrintGeneratedLottosDto;
import lotto.dto.output.PrintWinStatisticsDto;

import java.util.Map;

public final class OutputView {
    private OutputView() {
    }

    private static class OutputViewSingletonHelper {
        private static final OutputView OUTPUT_VIEW = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewSingletonHelper.OUTPUT_VIEW;
    }

    public void printGeneratedLottos(PrintGeneratedLottosDto dto) {
        Lottos lottos = dto.getLottos();
        StringBuilder result = new StringBuilder(
                String.format(ViewMessage.PURCHASE_AMOUNT.message, lottos.getLottoCount()));

        for (Lotto lotto : lottos) {
            result.append(lotto.toString()).append("\n");
        }

        print(result.toString());
    }

    public void printWinStatistics(PrintWinStatisticsDto dto) {
        ResultInformation resultInformation = dto.getResultInformation();
        print(getFormattedStatistics(resultInformation.getStatistics()));
        print(String.format(ViewMessage.TOTAL_PROFIT.message, resultInformation.getProfit()));
    }

    private String getFormattedStatistics(Map<Rank, Integer> statistics) {
        StringBuilder result = new StringBuilder(ViewMessage.STATISTICS_HEAD.message + ViewMessage.BARS.message);
        for (Rank value : Rank.values()) {
            if (value == Rank.MATCH0) {
                continue;
            }
            if (statistics.containsKey(value)) {
                result.append(String.format(ViewMessage.NORMAL_FORMAT.message,
                        value.getMessage(), statistics.get(value)));
                continue;
            }
            result.append(String.format(ViewMessage.NORMAL_FORMAT.message,
                    value.getMessage(), 0));
        }
        return result.toString();
    }

    public void printException(PrintExceptionDto dto) {
        print(dto.getException().getMessage());
    }

    public void print(String message) {
        System.out.println(message);
    }

    private enum ViewMessage {
        PURCHASE_AMOUNT("%d개를 구매했습니다.\n"),
        STATISTICS_HEAD("당첨 통계\n"),
        BARS("---\n"),
        NORMAL_FORMAT("%s - %d개\n"),
        TOTAL_PROFIT("총 수익률은 %s입니다.");

        private final String message;

        ViewMessage(String message) {
            this.message = message;
        }
    }
}
