package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by pasudo123 on 2019-12-04
 * Email: oraedoa@gmail.com
 **/
class CalculatorTest {

    @ParameterizedTest
    @DisplayName("쉼표와 콜론 구분자를 기준으로 분리한 각 숫자의 합을 계산한다.")
    @ValueSource(strings = {"1,2,3", "1:2,3", "1,2:3", "1:2:3"})
    void _addTest(String line) {

        Calculator calculator = new Calculator();

        assertThat(calculator.add(line))
                .as("길이가 0 이상이며 숫자를 포함한 문자열을 입력받고 6 을 리턴한다.")
                .isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("공백 및 구분자로 구성된 문자열의 합을 계산한다.")
    @ValueSource(strings = {"", ",,,", ",", ":,", ",,,"})
    void _addResultZeroTest(String line) {

        Calculator calculator = new Calculator();

        assertThat(calculator.add(line))
                .as("길이가 0 이며 숫자를 포함하지 않는 문자열을 입력받고 0 을 리턴한다.")
                .isEqualTo(0);
    }
}
