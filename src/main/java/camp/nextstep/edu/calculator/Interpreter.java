package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_SPLITTER = "([,:])";
    private static final int SPLITTER_GROUP = 1;
    private static final int INPUT_GROUP = 2;

    static String[] interpret(String input) {
        Matcher matcher = PATTERN.matcher(input);
        String splitter = DEFAULT_SPLITTER;

        if(matcher.find()) {
            splitter = matcher.group(SPLITTER_GROUP);
            input = matcher.group(INPUT_GROUP);
        }

        return input.split(splitter);
    }
}
