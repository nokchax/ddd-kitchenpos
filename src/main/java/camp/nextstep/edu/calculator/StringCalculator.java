package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

public class StringCalculator {

    private CustomTokenizer customTokenizer;

    private StringCalculator(){}

    public StringCalculator(final CustomTokenizer customTokenizer) {
        this.customTokenizer = customTokenizer;
    }

    public int add(final String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }
        final String[] tokens = customTokenizer.tokenize(text);
        return calculateSum(new CalculateNumbers(tokens));
    }

    private int calculateSum(final CalculateNumbers calculateNumbers) {
        return calculateNumbers.sum();
    }


}
