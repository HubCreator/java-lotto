package lotto.dto.output;

import lotto.domain.Lottos;

public class PrintGeneratedLottosDto {
    private final Lottos lottos;

    public PrintGeneratedLottosDto(Lottos lottos) {
        this.lottos = lottos;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
