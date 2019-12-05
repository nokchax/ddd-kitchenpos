package camp.nextstep.edu.calculator;

public class ValidatorImpl implements Validator{

    @Override
    public int possibleCalculateOrElseThrow(final String line) {

        if(line.isEmpty()) {
            return 0;
        }

        this.numberOrElseThrow(line);
        this.positiveOrElseThrow(line);

        return Integer.parseInt(line);
    }

    private void numberOrElseThrow(final String line){

        // 숫자가 아닌 경우
        try {
            Integer.parseInt(line);
        } catch (Exception e) {
            this.executeRuntimeException(line);
        }
    }

    private void positiveOrElseThrow(final String line) {

        // 음수인 경우
        if(Integer.parseInt(line) < 0) {
            this.executeRuntimeException(line);
        }
    }


    private void executeRuntimeException(final String line){
        throw new RuntimeException(String.format("\"%d\" 값이 들어왔기 때문에 덧셈을 수행하지 못합니다.", line));
    }
}
