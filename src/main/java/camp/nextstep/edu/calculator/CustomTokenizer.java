package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomTokenizer {

    static final String DEFAULT_STRING_DELIMITERS = "[,:]";
    static final Pattern REGEX_PATTERN = Pattern.compile("//(.)\n(.*)");
    static final int MATCHER_GROUP_DELIMITER_INDEX = 1;
    static final int MATCHER_GROUP_TOKENS_INDEX = 2;

    public String[] tokenize(final String text) {
        final Matcher matcher = REGEX_PATTERN.matcher(text);

        if (hasCustomSeparator(matcher)) {
            return customTokenize(matcher);
        }

        return text.split(DEFAULT_STRING_DELIMITERS);
    }

    private String[] customTokenize(final Matcher matcher) {
        final String customDelimiter = matcher.group(MATCHER_GROUP_DELIMITER_INDEX);
        final String customText = matcher.group(MATCHER_GROUP_TOKENS_INDEX);

        return customText.split(customDelimiter);
    }

    private boolean hasCustomSeparator(final Matcher matcher) {
        return matcher.matches();
    }
}
