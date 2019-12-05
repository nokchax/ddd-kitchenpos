package camp.nextstep.edu.calculator;

import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class DelimiterImpl implements Delimiter {

    private static final Pattern EXTRACT_SEPARATOR_PATTERN = compile("//(.)\\n(.*)");
    private static final String SEPARATOR_REGEX = "[:,]";

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

        String customDelimiter = matcher.group(1);

        return matcher.group(2)
                .split(customDelimiter);
    }

    private String[] useBasicSplitReturnArray(final String line) {
        return line.split(SEPARATOR_REGEX);
    }
}
