package camp.nextstep.edu.calculator;

public class ValidatorImpl implements Validator{

    @Override
    public int positiveOrElseThrow(final String line) {

        if(line.isEmpty()) {
            return 0;
        }

        int number = 0;

        try {

            number = Integer.parseInt(line);

        } catch (Exception e) {

            // 숫자 이외의 값.
            this.executeRuntimeException(line);
        }

        if(number < 0) {

            // 음수
            this.executeRuntimeException(line);
        }

        return number;
    }

    private void executeRuntimeException(final String line){
        throw new RuntimeException(String.format("\"%d\" 값이 들어왔기 때문에 덧셈을 수행하지 못합니다.", line));
    }
}
