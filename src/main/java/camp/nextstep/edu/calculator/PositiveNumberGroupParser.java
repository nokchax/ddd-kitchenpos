package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class PositiveNumberGroupParser {

    private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile("[,:]");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public PositiveNumberGroup parse(String text) {
        if (hasDefaultDelimiter(text)) {
            return toPositiveNumberGroupBySplit(text, DEFAULT_DELIMITER_PATTERN.pattern());
        }

        final Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (customDelimiterMatcher.find()) {
            final String customDelimiter = customDelimiterMatcher.group(1);
            return toPositiveNumberGroupBySplit(customDelimiterMatcher.group(2), customDelimiter);
        }

        return toPositiveNumberGroupBySplit(text, "");
    }

    private boolean hasDefaultDelimiter(String text) {
        return DEFAULT_DELIMITER_PATTERN.matcher(text).find();
    }

    private PositiveNumberGroup toPositiveNumberGroupBySplit(String text, String basicDelimiter) {
        final List<Integer> numbers = Arrays.stream(text.split(basicDelimiter))
                .map(Integer::parseInt)
                .collect(toList());

        return new PositiveNumberGroup(numbers);
    }
}
