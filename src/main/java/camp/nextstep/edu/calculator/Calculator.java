package camp.nextstep.edu.calculator;

import java.util.List;

/**
 * Created by pasudo123 on 2019-12-04
 * Email: oraedoa@gmail.com
 **/
public class Calculator {

    private final Validator validator;
    private final Delimiter delimiter;

    public Calculator() {
        this.validator = new ValidatorImpl();
        this.delimiter = new DelimiterImpl();
    }

    int add(final String line) {

        int sum = 0;

        List<String>tokens = delimiter.splitStringReturnList(line);

        for(String token : tokens) {
            sum += validator.positiveOrElseThrow(token);
        }

        return sum;
    }
}
