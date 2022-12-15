package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.ResultInformation;
import lotto.dto.output.PrintExceptionDto;
import lotto.dto.output.PrintGeneratedLottosDto;
import lotto.dto.output.PrintWinStatisticsDto;

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
            result.append(lotto.toString() + "\n");
        }
        System.out.println(result);
    }

    public void printWinStatistics(PrintWinStatisticsDto dto) {
        ResultInformation resultInformation = dto.getResultInformation();
        System.out.println(resultInformation.getProfit());
    }

    public void printException(PrintExceptionDto dto) {
        System.out.println(dto.getException().getMessage());
    }

    private void printMessage(ViewMessage viewMessage) {
        System.out.println(viewMessage);
    }

    private enum ViewMessage {
        PURCHASE_AMOUNT("%d개를 구매했습니다.\n");

        private final String message;

        ViewMessage(String message) {
            this.message = message;
        }
    }
}
