package camp.nextstep.edu.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * Created by pasudo123 on 2019-12-04
 * Email: oraedoa@gmail.com
 **/
public class Calculator {

    private final Pattern NUMBER_PATTERN = compile("([0-9]*)");
    private final Pattern SEPARATOR_PATTERN = compile("([:,])");
    private final Pattern EXTRACT_SEPARATOR_PATTERN = compile("//(.)\\n(.*)");

    private boolean isZero(String line) {

        return (line.isEmpty()
                || !NUMBER_PATTERN.matcher(line).find());
    }

    private String[] getCustomPatternArray(String line){

        Matcher matcher = EXTRACT_SEPARATOR_PATTERN.matcher(line);

        if(!matcher.find()) {
            return null;
        }

        String customDelimiter = matcher.group(1);
        String[] tokens = matcher.group(2).split(customDelimiter);

        return tokens;
    }

    int basicAdd(String line) {

        if(isZero(line)) {
            return 0;
        }

        int sum = 0;

        for(int i = 0; i < line.length(); i++) {

            char c = line.charAt(i);

            // String.valueOf() vs literal
            if(SEPARATOR_PATTERN.matcher( "" + c).find()){
                continue;
            }

            sum += Integer.parseInt("" + c);
        }

        return sum;
    }

    int customAdd(String line) {

        if(isZero(line)) {
            return 0;
        }

        String[]tokens = getCustomPatternArray(line);
        int sum = 0;

        for(int i = 0; i < tokens.length; i++) {
            sum += basicAdd(tokens[i]);
        }

        return sum;
    }
}
