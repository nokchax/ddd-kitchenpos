package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_SPLITTER = "([,:])";

    private Numbers numbers;

    static Interpreter of(String input) {
        Interpreter interpreter = new Interpreter();

        interpreter.numbers = new Numbers(interpret(input));

        return interpreter;
    }

    int calculate() throws RuntimeException {
        return this.numbers
                .sum();
    }

    private static String[] interpret(String input) {
        Matcher matcher = PATTERN.matcher(input);
        String splitter = DEFAULT_SPLITTER;

        if(matcher.find()) {
            splitter = matcher.group(1);
            input = matcher.group(2);
        }

        return input.split(splitter);
    }
}
