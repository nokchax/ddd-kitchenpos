package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int REMAIN_PART_GROUP = 2;

    public static String[] separate(String text) {
        Matcher customDelimitMatcher = CUSTOM_DELIMITER_PATTERN.matcher(text);

        if (customDelimitMatcher.find()) {
            return separateWithCustomDelimiter(
                    customDelimitMatcher.group(CUSTOM_DELIMITER_GROUP), customDelimitMatcher.group(REMAIN_PART_GROUP));
        }
        return separateWithDefaultDelimiter(text);

    }

    private static String[] separateWithCustomDelimiter(String customDelimiter, String remainPart) {
        return remainPart.split(String.join("|", DEFAULT_DELIMITER, customDelimiter));
    }

    private static String[] separateWithDefaultDelimiter(String text) {
        return text.split(DEFAULT_DELIMITER);
    }
}
