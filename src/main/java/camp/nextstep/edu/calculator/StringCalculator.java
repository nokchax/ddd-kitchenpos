package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

import java.util.List;

public class StringCalculator {

    public static int calculate(String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }

        final List<Integer> numbersFromText = new NumberGroupParser().parse(text);

        return new PositiveNumberGroup(numbersFromText).sumAll();
    }
}
