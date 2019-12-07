package camp.nextstep.edu.calculator;

public class StringCalculatorParser {
    public static Integer parserInt(String number) throws RuntimeException {
        Integer result = Integer.parseInt(number);
        if (result < 0) {
            throw new RuntimeException();
        }
        return result;
    }
}
