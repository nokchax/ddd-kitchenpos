package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Delimiter {

    private Delimiter(){}

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final int DELIMITER_GROUP_INDEX = 1;
    private static final int INPUT_GROUP_INDEX = 2;

    public static String[] separate(String text){

        final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        String delimiter = DEFAULT_DELIMITER;

        if(matcher.find()){
            delimiter = matcher.group(DELIMITER_GROUP_INDEX);
            text = matcher.group(INPUT_GROUP_INDEX);
        }
        return text.split(delimiter);

    }


}
