package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("자동차는 항상 true 로 이동한다.")
    void _carMoveTest() {

        Car car = new Car("ABC", 5);

        // 1 ~ 5
        for(int i = 1; i <= 5; i++) {
            car.move(new MockMovingTrueStrategy());
        }

        assertThat(car.isInPosition(5 * 2)).isTrue();
    }

    @Test
    @DisplayName("자동차는 항상 false 로 이동하지 않는다.")
    void _carMoveFailTest() {

        Car car = new Car("ABC", 5);

        for(int i = 1; i <= 5; i++) {
            car.move(new MockMovingFailStrategy());
        }

        assertThat(car.isInPosition(5)).isTrue();
    }

    /** true **/
    // src 에서 interface 선언, parameter 변경, mock 객체를 통한 테스트
    class MockMovingTrueStrategy implements MovingStrategy{
        @Override
        public boolean movable() {
            return true;
        }
    }

    /** false **/
    class MockMovingFailStrategy implements MovingStrategy{
        @Override
        public boolean movable() {
            return false;
        }
    }
}
