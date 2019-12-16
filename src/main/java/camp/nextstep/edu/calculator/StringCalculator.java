package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

public class StringCalculator {

    public StringCalculator(){}

    public int calculate(final String text){

        if(isEmptyOrNull(text)){
            return 0;
        }
        final String[] separated = Delimiter.separate(text);
        return Number.addAllNumberInStringArray(separated);
    }

    private boolean isEmptyOrNull(final String text){
        return StringUtils.isEmpty(text);
    }

}
