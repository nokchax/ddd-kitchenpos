package camp.nextstep.edu.kitchenpos.parameterizedTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomArgumentTest {
    @ParameterizedTest
    @ArgumentsSource(BlankStringArgumentProvider.class)
    void isBlank_ShouldReturnTrueForNullOrBlankStringsArgProvider(String input) {
        assertTrue(Strings.isBlank(input));
    }
}
