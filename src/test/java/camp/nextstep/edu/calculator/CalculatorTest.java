package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


/**
 * Created by pasudo123 on 2019-12-04
 * Email: oraedoa@gmail.com
 **/
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        this.calculator = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("null 값 또는 공백을 계산한다.")
    @NullAndEmptySource
    void _nullAndEmptyAddTest(String line) {

        assertThat(calculator.add(line))
                .as("null 또는 공백이 들어왔고, 0을 리턴한다.")
                .isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("쉼표와 콜론 구분자를 기준으로 분리한 각 숫자의 합을 계산한다.")
    @ValueSource(strings = {"1,2,3", "1:2,3", "1,2:3", "1:2:3"})
    void _addTest(String line) {

        assertThat(calculator.add(line))
                .as("길이가 0 이상이며 숫자를 포함한 문자열을 입력받고 6 을 리턴한다.")
                .isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("공백 및 구분자로 구성된 문자열의 합을 계산한다.")
    @ValueSource(strings = {",,,", ":,", ",:,", ":", ","})
    void _addResultZeroTest(String line) {

        assertThat(calculator.add(line))
                .as("길이가 0 이며 숫자를 포함하지 않는 문자열을 입력받고 0 을 리턴한다.")
                .isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자를 지정하여 덧셈을 수행한다.")
    @ValueSource(strings = {"//;\n1,2;3", "//@\n1@2,3", "//=\n1=2=3", "//&\n1&2:3"})
    void _customAddTest(String line) {

        assertThat(calculator.add(line))
                .as("커스텀 구분자가 있는 문자열을 받고 분리하여 6 을 리턴한다.")
                .isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("숫자 이외의 값 또는 음수를 전달하여 RuntimeException 예외를 throw 한다.")
    @ValueSource(strings = {"sss", "-1", "-10", "-100"})
    void _throwRuntimeExceptionTest(String line) {

        assertThatThrownBy(() -> {
            calculator.add(line);
        }).isInstanceOf(RuntimeException.class);
    }
}
