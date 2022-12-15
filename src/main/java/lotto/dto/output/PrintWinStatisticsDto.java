package lotto.dto.output;

import lotto.domain.ResultInformation;

public class PrintWinStatisticsDto {

    private final ResultInformation resultInformation;

    public PrintWinStatisticsDto(ResultInformation resultInformation) {
        this.resultInformation = resultInformation;
    }

    public ResultInformation getResultInformation() {
        return resultInformation;
    }
}
