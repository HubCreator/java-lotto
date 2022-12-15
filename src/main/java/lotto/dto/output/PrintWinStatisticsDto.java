package lotto.dto.output;

import lotto.domain.ResultInformation;

public final class PrintWinStatisticsDto {

    private final ResultInformation resultInformation;

    public PrintWinStatisticsDto(ResultInformation resultInformation) {
        this.resultInformation = resultInformation;
    }

    public ResultInformation getResultInformation() {
        return resultInformation;
    }
}
