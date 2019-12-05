package camp.nextstep.edu.calculator;

import java.util.Arrays;

public final class Number {

    private Number(){}

    public static int addAllNumberInStringArray(String[] separated){
        return Arrays.stream(separated)
                .mapToInt(Number::validate)
                .sum();
    }

    private static int validate(String text){
        int number = Integer.parseInt(text);
        if(number < 0){
            throw new RuntimeException("음수 x");
        }
        return number;
    }


}
