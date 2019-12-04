package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

public class StringCalculator {

    public static int calculate(String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }

        return new PositiveNumberGroupParser().parse(text).sumAll();
    }
}
