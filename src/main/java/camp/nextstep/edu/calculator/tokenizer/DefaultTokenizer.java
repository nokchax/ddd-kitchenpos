package camp.nextstep.edu.calculator.tokenizer;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class DefaultTokenizer implements Tokenizer {

    private static final int TOKEN_INDEX = 1;
    private static final int TEXT_INDEX = 2;

    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    private final Tokenizer basicTokenizer = new BasicTokenizer();

    @Override
    public List<String> split(String text) {

        final Matcher customDelimiterMatcher = PATTERN.matcher(text);

        if (customDelimiterMatcher.find()) {
            final String customDelimiter = customDelimiterMatcher.group(TOKEN_INDEX);
            final String customText = customDelimiterMatcher.group(TEXT_INDEX);

            return Arrays.stream(customText.split(customDelimiter))
                    .collect(toList());
        }

        return basicTokenizer.split(text);
    }

}
