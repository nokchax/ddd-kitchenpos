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

    private void validateNumber(String paramNumber) {

        if(!NUMBER_PATTERN.matcher(paramNumber).find() || Integer.parseInt(paramNumber) < 0){
            throw new RuntimeException(String.format("\"%d\" 값이 들어왔기 때문에 덧셈을 수행하지 못합니다.", paramNumber));
        }
    }

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

        return matcher.group(2).split(customDelimiter);
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

            validateNumber(c + "");
            sum += Integer.parseInt("" + c);
        }

        return sum;
    }

    int customAdd(String line) {

        if(isZero(line)) {
            return 0;
        }

        int sum = 0;
        String[]tokens = getCustomPatternArray(line);

        if(tokens == null) {
            return sum;
        }

        for (String token : tokens) {
            sum += basicAdd(token);
        }

        return sum;
    }
}
