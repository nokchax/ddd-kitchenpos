package camp.nextstep.edu.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InterpreterTest {
    @ParameterizedTest
    @MethodSource
    void addWithCommaAndSemicolon(String input, String[] answer) {
        assertThat(Interpreter.interpret(input)).containsOnlyElementsOf(Arrays.asList(answer));
    }

    private static Stream addWithCommaAndSemicolon() {
        return Stream.of(
                Arguments.of("1,2", new String[] {"1", "2"}),
                Arguments.of("1,2,3", new String[] {"1", "2", "3"}),
                Arguments.of("1,2:3", new String[] {"1", "2", "3"})
        );
    }


}