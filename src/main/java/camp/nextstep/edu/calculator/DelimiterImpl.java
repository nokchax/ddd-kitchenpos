package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public final class DelimiterImpl implements Delimiter {

    private static final Pattern EXTRACT_SEPARATOR_PATTERN = compile("//(.)\\n(.*)");
    private static final String SEPARATOR_REGEX = "[:,]";
    private static final Integer FIRST_GROUP = 1;
    private static final Integer SECOND_GROUP = 2;

    @Override
    public List<String> splitStringReturnList(final String line) {

        List<String> tokenList = new ArrayList<>();

        for(String token : useCustomSplitReturnArray(line)){
            tokenList.addAll(
                    Arrays.asList(useBasicSplitReturnArray(token))
            );
        }

        return tokenList;
    }

    private String[] useCustomSplitReturnArray(final String line) {

        Matcher matcher = EXTRACT_SEPARATOR_PATTERN.matcher(line);

        if(!matcher.find()) {
            return useBasicSplitReturnArray(line);
        }

        final String customDelimiter = matcher.group(FIRST_GROUP);

        return matcher.group(SECOND_GROUP)
                .split(customDelimiter);
    }

    private String[] useBasicSplitReturnArray(final String line) {
        return line.split(SEPARATOR_REGEX);
    }
}
