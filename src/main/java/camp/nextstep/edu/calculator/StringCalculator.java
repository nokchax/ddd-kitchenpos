package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    static final String STRING_SEPARATOR = "[,:]";
    static final Pattern REGEX_PATTERN = Pattern.compile("//(.)\n(.*)");
    static final int MATCHER_GROUP_SEPARATOR_INDEX = 1;
    static final int MATCHER_GROUP_TOKENS_INDEX = 2;

    public int add(String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }
        return new CalculateNumbers(separate(text)).sum();
    }

    private String[] separate(String text) {
        if (!hasCustomSeparator(text)) {
            return text.split(STRING_SEPARATOR);
        }

        final Matcher matcher = REGEX_PATTERN.matcher(text);
        matcher.matches();

        final String customSeparator = matcher.group(MATCHER_GROUP_SEPARATOR_INDEX);
        final String tokens = matcher.group(MATCHER_GROUP_TOKENS_INDEX);

        final String orOperator = "|";
        final String finalSeparator = String.join(orOperator, STRING_SEPARATOR, customSeparator);

        return tokens.split(finalSeparator);
    }

    private boolean hasCustomSeparator(String text) {
        return REGEX_PATTERN.matcher(text)
                .find();
    }


}
