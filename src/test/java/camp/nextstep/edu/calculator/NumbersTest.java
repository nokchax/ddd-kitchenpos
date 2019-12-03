package camp.nextstep.edu.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {
    @ParameterizedTest
    @MethodSource
    void initTest(List<String> inputs) {
        assertDoesNotThrow(() -> new Numbers(inputs.toArray(new String[]{})));
    }

    // array 전달이 안되네..
    private static Stream<List<String>> initTest() {
        return Stream.of(
                Arrays.asList("1", "2", "3"),
                Arrays.asList("0", "1")
        );
    }

    @ParameterizedTest
    @MethodSource
    void initFailTest(List<String> inputs) {
        assertThatThrownBy(() -> new Numbers(inputs.toArray(new String[]{}))).isInstanceOf(RuntimeException.class);
    }

    private static Stream<List<String>> initFailTest() {
        return Stream.of(
                Arrays.asList("1", "", "3"),
                Arrays.asList("a", "b", "c"),
                Arrays.asList("0", "-1")
        );
    }

    @ParameterizedTest
    @MethodSource
    void sumTest(List<String> inputs, int answer) {
        Numbers numbers = new Numbers(inputs.toArray(new String[]{}));
        assertThat(numbers.sum()).isSameAs(answer);
    }

    private static Stream sumTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("1", "2", "3"), 6),
                Arguments.of(Arrays.asList("0", "1"), 1)
        );
    }

}