package camp.nextstep.edu.calculator.delimiter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class CustomDelimiter implements Delimiter {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    @Override
    public List<String> split(String text) {

        final Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (customDelimiterMatcher.find()) {
            final String customDelimiter = customDelimiterMatcher.group(1);
            final String value = customDelimiterMatcher.group(2);

            return Arrays.stream(value.split(customDelimiter))
                    .collect(toList());
        }

        return Collections.emptyList();
    }
}
