package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String STRING_SEPARATOR = "[,:]";
    public static final Pattern REGEX_PATTERN = Pattern.compile("//(.)\n(.*)");

    public int add(String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }

        final String[] strings = separate(text);
        final NumberList separatedNumberList = new NumberList(strings);

        return separatedNumberList.sum();
    }

    private String[] separate(String text) {
        if (hasCustomSeparator(text)) {
            final Matcher matcher = REGEX_PATTERN.matcher(text);
            matcher.matches();
            final String customSeparator = matcher.group(1);
            return matcher.group(2).split(STRING_SEPARATOR + "|" + customSeparator);
        }

        return text.split(STRING_SEPARATOR);
    }

    private boolean hasCustomSeparator(String text) {
        return REGEX_PATTERN.matcher(text).find();
    }


}
