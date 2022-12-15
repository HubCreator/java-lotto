package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.enums.ConstVariable;

import java.util.List;

public class GenerateRandomNumberUtil {

    public static Lotto generateLotto() {
        List<Integer> result = Randoms.pickUniqueNumbersInRange(ConstVariable.MIN.getValue(),
                ConstVariable.MAX.getValue(),
                ConstVariable.SIZE.getValue());
        return new Lotto(result);
    }

}
