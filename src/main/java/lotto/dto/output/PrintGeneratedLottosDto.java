package lotto.dto.output;

import lotto.domain.Lottos;

public final class PrintGeneratedLottosDto {
    private final Lottos lottos;

    public PrintGeneratedLottosDto(Lottos lottos) {
        this.lottos = lottos;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
