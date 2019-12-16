package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by pasudo123 on 2019-12-02
 * Email: oraedoa@gmail.com
 **/
class CarTest {

    Logger logger = LoggerFactory.getLogger(CarTest.class);

    @Test
    @DisplayName("DisplayName Annotation. Test")
    void _displayAnnotationTest() {
        logger.info("DisplayName Annotation Test Successful");
    }

    @ParameterizedTest
    @DisplayName("자동차 이름은 다섯글자를 넘지 않는다.")
    @ValueSource(strings = {"A", "AB", "ABC", "ABCD", "ABCDE"})
    void _carNameNoMoreThanFiveCharactersTest(String name) {

        logger.info("자동차의 이름은 \"{}\" 입니다.", name);

        int position = name.length();

        final Car car = new Car(name, position);

        assertThat(car.isInPosition(position)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 다섯글자를 초과하면 에러를 발생시킨다.")
    @ValueSource(strings = {"QWERTY", "QWERTYU", "QWERTYUI", "QWERTYUIO", "QWERTYUIOP"})
    void _carNameExceedFiveCharactersTest(String name) {

        logger.info("자동차의 이름은 \"{}\" 입니다.", name);

        int position = name.length();

        assertThatThrownBy(() -> {
            final Car car = new Car(name, position);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("자동차는 주어진 movable 값에 따라서 위치를 움직인다.")
    @MethodSource("carMovableProvider")
    void _carMoveTest(boolean movable, int position) {

        final Car car = new Car("Par");
        car.move(() -> movable);

        assertThat(car.isInPosition(position));
    }

    static Stream<Arguments> carMovableProvider() {
        return Stream.of(
                Arguments.of(true, 1),
                Arguments.of(false, 0)
        );
    }
}
