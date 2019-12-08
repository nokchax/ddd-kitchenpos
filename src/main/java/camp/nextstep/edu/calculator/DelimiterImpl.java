package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public final class DelimiterImpl implements Delimiter {

    private static final Pattern EXTRACT_SEPARATOR_PATTERN = compile("//(.)\\n(.*)");
    private static final String SEPARATOR_RegExr = "[:,]";
    private static final Integer EXTRACT_CUSTOM_DELIMITER_INDEX = 1;
    private static final Integer EXTRACT_TOKENS_INDEX = 2;

    @Override
    public List<String> getListBySeparatorPattern(final String line) {

        final List<String> tokenList = new ArrayList<>();

        final Matcher matcher = EXTRACT_SEPARATOR_PATTERN.matcher(line);

        if(!matcher.find()) {
            return getListByDefaultSeparatorPattern(line);
        }

        final String customDelimiter = matcher.group(EXTRACT_CUSTOM_DELIMITER_INDEX);
        final String[] tokens = matcher.group(EXTRACT_TOKENS_INDEX).split(customDelimiter);

        // custom 과 default 가 섞여있는 문자열.
        for(String token : tokens) {
            tokenList.addAll(getListByDefaultSeparatorPattern(token));
        }

        return tokenList;
    }

    private List<String> getListByDefaultSeparatorPattern(final String token) {

        if(token.length() == 1) {
            return Collections.singletonList(token);
        }

        return Arrays.asList(
                token.split(SEPARATOR_RegExr));
    }
}
