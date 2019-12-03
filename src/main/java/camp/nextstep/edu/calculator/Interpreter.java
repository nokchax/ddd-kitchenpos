package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_SPLITTER = "([,:])";

    private Numbers numbers;

    static Interpreter interpret(String input) {
        Interpreter interpreter = new Interpreter();

        interpreter.numbers = new Numbers(interpretInput(input));

        return interpreter;
    }

    // remove throws runtime exception... is this good code?
    int calculate() {
        return this.numbers
                .sum();
    }

    private static String[] interpretInput(String input) {
        Matcher matcher = PATTERN.matcher(input);
        String splitter = DEFAULT_SPLITTER;

        if(matcher.find()) {
            splitter = matcher.group(1);
            input = matcher.group(2);
        }

        return input.split(splitter);
    }
}
