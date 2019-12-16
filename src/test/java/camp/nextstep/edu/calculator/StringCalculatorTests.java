package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTests {

    @DisplayName("문자열 계산기, 계산(NULL And Empty)")
    @ParameterizedTest
    @NullAndEmptySource
    public void testCalculateWithNull(String text) {
        assertEquals(0, StringCalculator.calculate(text));
    }

    @DisplayName("문자열 계산기, 계산(양수)")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void testCalculateWithOnePositiveNumber(String text) {
        assertEquals(Integer.parseInt(text), StringCalculator.calculate(text));
    }

    @DisplayName("문자열 계산기, 계산(음수)")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    public void testCalculateWithOneNegativeNumber(String text) {
        assertThrows(RuntimeException.class, () -> StringCalculator.calculate(text));
    }

    @DisplayName("문자열 계산기, 계산(NaN)")
    @ParameterizedTest
    @ValueSource(strings = {"A", "나", "-"})
    public void testCalculateWithOneNan(String text) {
        assertThrows(RuntimeException.class, () -> StringCalculator.calculate(text));
    }

    @DisplayName("문자열 계산기, 계산(콤마패턴)")
    @ParameterizedTest
    @ValueSource(strings = {"1,3", "2,2", "3,1"})
    public void testCalculateWithCommaPatten(String text) {
        assertEquals(4, StringCalculator.calculate(text));
    }

    @DisplayName("문자열 계산기, 계산(콤마패턴(음수))")
    @ParameterizedTest
    @ValueSource(strings = {"-1,3", "-2,2", "-3,1"})
    public void testCalculateWithCommaPattenAndNegative(String text) {
        assertThrows(RuntimeException.class, () -> StringCalculator.calculate(text));
    }

    @DisplayName("문자열 계산기, 계산(콤마패턴(NAN))")
    @ParameterizedTest
    @ValueSource(strings = {"가,3", "-,2", "A,3"})
    public void testCalculateWithCommaPattenAndNaN(String text) {
        assertThrows(RuntimeException.class, () -> StringCalculator.calculate(text));
    }

    @DisplayName("문자열 계산기, 계산(콜론패턴)")
    @ParameterizedTest
    @ValueSource(strings = {"1:3", "2:2", "3:1"})
    public void testCalculateWithColonPattern(String text) {
        assertEquals(4, StringCalculator.calculate(text));
    }

    @DisplayName("문자열 계산기, 계산(커스텀패턴)")
    @ParameterizedTest
    @ValueSource(strings = {"//_\n1_3", "//_\n3_1", "//_\n2_2"})
    public void testCalculateWithCustomPattern(String text) {
        assertEquals(4, StringCalculator.calculate(text));
    }
}
