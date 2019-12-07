package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

import java.util.Arrays;

import static camp.nextstep.edu.calculator.StringCalculatorParser.parserInt;

public class StringCalculator {

    public Integer sum(String text) {
        if (StringUtils.isEmpty(text)) {
            return sumNullOrEmptyString();
        }
        return sum(StringSeparator.separate(text));
    }

    private Integer sum(String[] separateText) {
        return Arrays.stream(separateText).mapToInt(s -> parserInt(s)).sum();
    }

    private Integer sumNullOrEmptyString() {
        return 0;
    }
}
