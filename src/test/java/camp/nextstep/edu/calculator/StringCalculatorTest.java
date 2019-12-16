package camp.nextstep.edu.calculator;

import camp.nextstep.edu.racingcar.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class StringCalculatorTest {

    private static final Logger log = LoggerFactory.getLogger(StringCalculatorTest.class);

    private StringCalculator stringCalculator;

    @BeforeEach
    public void assign(){
        stringCalculator = new StringCalculator();
    }

    @DisplayName("빈 문자열 또는 null 을 입력하면 0을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    public void 빈문자열_또는_널_입력_0반환(final String text){
         assertThat(stringCalculator.calculate(text)).isZero();
    }
    @DisplayName(value = "구분자 쉼표(,) 이외에 콜론(:)을 사용하여 나누고 계산한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3"})
    public void 구분자로_나눈후_계산(final String text) {
        //given
            log.info("text : {}",text);
        //when
            int result = stringCalculator.calculate(text);
            int expected = 6;
        //then
        assertThat(result).isSameAs(expected);
    }
    @DisplayName(value = "커스텀 구분자로도 나누어 계산한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    public void 커스텀구분자로_나눈후_계산(final String text) {
        //given
            log.info("text : {}",text);
        //when
            int result = stringCalculator.calculate(text);
            int expected = 6;
        //then
            assertThat(result).isSameAs(expected);
    }
    @DisplayName(value = "음수를 전달하면 런타임익셉션이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n-1;2;3"})
    public void 음수전달_런타임익셉션_발생(final String text) {
        //given
            log.info("text : {}",text);
        //when
            assertThatThrownBy(()->{
                stringCalculator.calculate(text);
            })
        //then
            .isInstanceOf(RuntimeException.class);
    }
    @DisplayName(value = "숫자 하나를 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"5"})
    public void 숫자하나_입력_해당숫자_반환(final String text) {
        //given
            log.info("text : {}", text);
        //when
            int result = stringCalculator.calculate(text);
            int expected = Integer.parseInt(text);
        //then
            assertThat(result).isSameAs(expected);
    }

}