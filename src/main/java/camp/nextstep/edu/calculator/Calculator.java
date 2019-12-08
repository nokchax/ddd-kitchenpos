package camp.nextstep.edu.calculator;

import java.util.List;

public class Calculator {

    private static final Integer ZERO = 0;

    private Validator validator = new ValidatorImpl();
    private Delimiter delimiter = new DelimiterImpl();

    Calculator() { }

    public void updateValidator(final Validator validator) {
        this.validator = validator;
    }

    public void updateDelimiter(final Delimiter delimiter){
        this.delimiter = delimiter;
    }

    int add(final String line) {

        int sum = 0;

        if(validator.isZeroIfNullOrEmpty(line)) {
            return ZERO;
        }

        List<String>tokens = delimiter.splitStringReturnList(line);

        for(String token : tokens) {
            sum += validator.calculateIfPossibleOrElseThrow(token);
        }

        return sum;
    }
}
