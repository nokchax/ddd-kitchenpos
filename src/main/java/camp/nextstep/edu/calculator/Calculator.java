package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

public class Calculator {

    int add(String input) {
        if(isEmpty(input))
            return 0;

        return Interpreter.of(input)
                .calculate();
    }

    private boolean isEmpty(String input) {
        return StringUtils.isEmpty(input);
    }
}
