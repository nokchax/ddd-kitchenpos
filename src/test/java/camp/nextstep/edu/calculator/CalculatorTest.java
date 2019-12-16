package camp.nextstep.edu.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @ParameterizedTest
    @MethodSource("addWithCommaAndSemicolonParams")
    void addWithCommaAndSemicolon(String input, int answer) {
        Calculator calculator = new Calculator();
        assertThat(calculator.add(input)).isSameAs(answer);
    }

    private static Stream addWithCommaAndSemicolonParams() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of("", 0),
                Arguments.of("1,2", 3),
                Arguments.of("1,2,3", 6),
                Arguments.of("1,2:3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("addWithCustomSplitter")
    void addWithCustomSplitter(String input, int answer) {
        Calculator calculator = new Calculator();
        assertThat(calculator.add(input)).isSameAs(answer);
    }

    private static Stream addWithCustomSplitter() {
        return Stream.of(
                Arguments.of("//a\n1a2", 3),
                Arguments.of("//!\n1!2!3", 6)
        );
    }

}