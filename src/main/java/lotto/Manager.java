package lotto;

import lotto.controller.Controller;
import lotto.domain.Status;
import lotto.util.StandardRandomNumberGenerator;
import lotto.view.IOViewResolver;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class Manager {
    private static final Status INITIAL_STATUS = Status.INPUT_PURCHASE_AMOUNT;

    private Manager() {

    }

    public static void run() {
        IOViewResolver ioViewResolver = new IOViewResolver(InputView.getInstance(), OutputView.getInstance());
        Controller controller = new Controller(ioViewResolver, new StandardRandomNumberGenerator());
        Status currentStatus = INITIAL_STATUS;

        while (currentStatus != Status.EXIT) {
            currentStatus = controller.run(currentStatus);
        }
    }
}
