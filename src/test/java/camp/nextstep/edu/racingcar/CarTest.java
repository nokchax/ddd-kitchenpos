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
    @DisplayName("자동차 이름은 4글자는 가능")
    @ValueSource(strings = {"네글자는", "다섯글자는"})
    void carNameTest(final String carName) {
        assertDoesNotThrow(() -> new Car(carName));
    }

    @ParameterizedTest
    @DisplayName("4이상인 경우 움직여라!")
    @MethodSource
    void carMoveTest(StaticNumMovingStrategy movingStrategy, int position) {
        Car car = new Car("Test");
        car.move(movingStrategy);
        assertTrue(car.isInPosition(position));
    }


    private static Stream carMoveTest() {
        return Stream.of(
                Arguments.of(new StaticNumMovingStrategy(3), 0),
                Arguments.of(new StaticNumMovingStrategy(4), 1),
                Arguments.of(new StaticNumMovingStrategy(5), 1)
        );
    }

    private static class StaticNumMovingStrategy implements MovingStrategy {
        private int staticNum;

        StaticNumMovingStrategy(int staticNum) {
            this.staticNum = staticNum;
        }

        @Override
        public boolean movable() {
            return staticNum >= 4;
        }
    }
}
