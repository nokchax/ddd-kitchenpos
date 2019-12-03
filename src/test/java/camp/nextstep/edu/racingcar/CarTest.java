package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;


/*
    1. 자동차 이름은 5글자를 넘을 수 없다.
    2. 5글자가 넘는 경우, IllegalArgumentException이 발생한다.
    3. 자동차가 움직이는 조건은 0에서 9사이의 무작위 값을 구한 후, 무작위 값이 4 이상인 경우이다.
 */
public class CarTest {
    // 하나로 합칠순 없을까?
    @ParameterizedTest
    @DisplayName("자동차 이름은 5글자를 넘을 수 없다.")
    @NullSource
    @ValueSource(strings = {"다섯글자넘음"})
    void carNameLimitTest(final String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름은 4글자 가능")
    @ValueSource(strings = {"네글자는", "다섯글자는"})
    void carNameTest(final String carName) {
        assertDoesNotThrow(() -> new Car(carName));
    }

    @ParameterizedTest
    @DisplayName("4이상인 경우에만 움직일 수 있다.")
    @MethodSource
    void carMoveTest(MovingStrategy movingStrategy, int position) {
        Car car = new Car("Test");
        car.move(movingStrategy);
        assertTrue(car.isInPosition(position));
    }

    private static Stream carMoveTest() {
        return Stream.of(
                Arguments.of(new FixedNumberMovingStrategy(3), 0),
                Arguments.of(new FixedNumberMovingStrategy(4), 1),
                Arguments.of(new FixedNumberMovingStrategy(5), 1)
        );
    }

    private static class FixedNumberMovingStrategy implements MovingStrategy {
        private int fixedNumber; // static means fixed

        FixedNumberMovingStrategy(int fixedNumber) {
            this.fixedNumber = fixedNumber;
        }

        @Override
        public boolean movable() {
            return fixedNumber >= 4;
        }
    }
}
