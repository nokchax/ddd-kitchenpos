package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

public final class ValidatorImpl implements Validator {

    private static final Integer ZERO = 0;

    @Override
    public boolean isZeroIfNullOrEmpty(String line) {
        return StringUtils.isEmpty(line);
    }

    @Override
    public int calculateIfPossibleOrElseThrow(final String line) {

        this.throwIfNegativeOrNoneNumber(line);

        return getIntegerOnString(line);
    }


    private void throwIfNegativeOrNoneNumber(final String line) {

        try {
            // 숫자 또는 음수가 아닌 경우 : 에러발생.
            // RuntimeException 이 자동으로 발생하기 때문에 무방하긴 함.
            if (getIntegerOnString(line) < ZERO) {
                this.executeRuntimeException(line);
            }
        } catch (Exception e) {
            this.executeRuntimeException(line);
        }
    }

    private int getIntegerOnString(final String line) {
        return Integer.parseInt(line);
    }

    private void executeRuntimeException(final String line) {
        throw new RuntimeException(String.format("\"%s\" 값이 들어왔기 때문에 덧셈을 수행하지 못합니다.", line));
    }
}
