package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_SPLITTER = "([,:])";
    private Numbers numbers;
    private String splitter = DEFAULT_SPLITTER;

    static Interpreter of(String input) {
        Interpreter interpreter = new Interpreter();

        Matcher matcher = PATTERN.matcher(input);
        if(matcher.find()) {
            interpreter.splitter = matcher.group(1);
            input = matcher.group(2);
        }

        interpreter.numbers = new Numbers(input.split(interpreter.splitter));

        return interpreter;
    }

    int calculate() throws RuntimeException {
        return this.numbers
                .sum();
    }
}
