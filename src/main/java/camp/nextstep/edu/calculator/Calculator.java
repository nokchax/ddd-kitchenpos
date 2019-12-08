package camp.nextstep.edu.calculator;

import java.util.Iterator;

public class Calculator {

    private static final Integer ZERO = 0;

    private Validator validator = new ValidatorImpl();
    private Delimiter delimiter = new DelimiterImpl();

    public Calculator() { }

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

        final TokenList tokenList = delimiter.getListBySeparatorPattern(line);

        final Iterator<String> iterator = tokenList.iterator();

        while(iterator.hasNext()){
            sum += validator.calculateIfPossibleOrElseThrow(iterator.next());
        }

        return sum;
    }
}
