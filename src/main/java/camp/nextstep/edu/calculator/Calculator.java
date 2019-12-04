package camp.nextstep.edu.calculator;

import java.util.regex.Pattern;

/**
 * Created by pasudo123 on 2019-12-04
 * Email: oraedoa@gmail.com
 **/
public class Calculator {

    final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]*)");
    final Pattern SEPARATOR_PATTERN = Pattern.compile("(:|,)");

    private boolean isZero(String line) {

        return (line.isEmpty()
                || !NUMBER_PATTERN.matcher(line).find());

    }

    int add(String line) {

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
}
