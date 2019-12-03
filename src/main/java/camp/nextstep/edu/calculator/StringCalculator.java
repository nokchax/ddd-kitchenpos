package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private String delimiterRegex;

    private static final String DEFAULT_DELIMITER_REST = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";

    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\n";

    private static final String ONLY_NUMBER_PATTERN = "^[0-9]+$";

    public StringCalculator() {
        delimiterRegex = DEFAULT_DELIMITER_REST + "|" + DEFAULT_DELIMITER_COLON;
    }

    public Integer add(String text) {
        if (text == null || text.isEmpty())
            return addNullOrEmptyString(text);

        if (isNumber(text))
            return addOnlyOneNumber(text);

        return addWithDelimiters(text);
    }

    private Integer addNullOrEmptyString(String text) {
        return 0;
    }

    private Integer addOnlyOneNumber(String text) throws RuntimeException {
        Integer result = Integer.parseInt(text);
        if (result < 0)
            throw new RuntimeException();
        return result;
    }

    private Boolean isNumber(String text) {
        return Pattern.matches(ONLY_NUMBER_PATTERN, text);
    }

    private Integer addWithCustomDelimiters(String text, Matcher customDelimitMatcher) {
        putDelimiter(customDelimitMatcher.group(1));
        return addStringNumbers(customDelimitMatcher.group(2));
    }

    private void putDelimiter(String customDelimiter) {
        delimiterRegex += "|" + customDelimiter;
    }

    private Integer addWithDelimiters(String text) {
        Matcher customDelimitMatcher = Pattern.compile(CUSTOM_DELIMITER_START + "(.)" + CUSTOM_DELIMITER_END + "(.*)")
                .matcher(text);
        if (customDelimitMatcher.find())
            return addWithCustomDelimiters(text, customDelimitMatcher);
        return addStringNumbers(text);
    }

    private Integer addStringNumbers(String text) {
        String[] numbers = text.split(delimiterRegex);
        Integer result = 0;

        for (String number : numbers)
            result += addOnlyOneNumber(number);
        return result;
    }
}
