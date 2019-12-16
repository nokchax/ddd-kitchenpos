package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.tokenizer.DefaultTokenizer;
import camp.nextstep.edu.calculator.tokenizer.Tokenizer;
import org.springframework.util.StringUtils;

import java.util.List;


public final class StringCalculator {

    private StringCalculator() {
    }

    public static int calculate(String text) {
        return calculate(text, new DefaultTokenizer());
    }

    public static int calculate(String text, Tokenizer tokenizer) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }

        final List<Integer> numbersFromText = new NumberGroupParser(tokenizer).parse(text);

        return new PositiveNumberGroup(numbersFromText).sumAll();
    }
}
