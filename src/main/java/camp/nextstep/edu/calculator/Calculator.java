package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

public class Calculator {

    int add(String input) {
        if(isEmpty(input))
            return 0;

        return new Numbers(Interpreter.interpret(input))
                .sum();
    }

    private boolean isEmpty(String input) {
        return StringUtils.isEmpty(input);
    }
}
