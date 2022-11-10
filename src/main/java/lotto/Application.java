package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.ResultStatistics;
import lotto.domain.WinLotto;
import lotto.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");

        String amount = Console.readLine();
        Util.isValidAmount(amount);
        int count = Integer.parseInt(amount) / 1000;
        System.out.println(count + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.create();
            lottos.add(lotto);
            System.out.println(lotto.printNumbers());
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String winNumbers = Console.readLine();
        List<Integer> validatedWinNumbers = Util.isValidWinNumbers(winNumbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        WinLotto winLotto = new WinLotto(validatedWinNumbers, Integer.parseInt(bonusNumber));


        System.out.println("당첨 통계");
        System.out.println("---");

        List<Result> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            Result result = winLotto.getResult(lotto);
            results.add(result);
        }

        ResultStatistics statistics = new ResultStatistics(results);
        System.out.println(statistics.printResultStatistics());
    }
}
