package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {

    @DisplayName("자동차 정상 생성 ")
    @ValueSource(strings = {"123", "12", "1234", "12345"})
    @ParameterizedTest
    public void createCar(String name) {
        int position = 1;

        Car car = new Car(name, position);

        assertThat(car).isNotNull();
    }

    @DisplayName("자동차 이름은 5글자를 넘을 수 없다. 5 글자가 넘는 경우, IllegalArgumentException이 발생한다.")
    @ValueSource(strings = {"123456", "1234567", "다섯글자넘어요"})
    @ParameterizedTest
    public void limitCarNameLengthTo5(String name) {
        int position = 1;

        assertAll(
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> new Car(name, position)),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> new Car(name))
        );

    }

    @DisplayName("자동차는 조건에 따라 움직인다.")
    @MethodSource("movableProvider")
    @ParameterizedTest
    public void carMovingTest(boolean movable, int position) {

        String carName = "car";
        Car car = new Car(carName);

        car.move(() -> movable);

        assertThat(car.isInPosition(position)).isTrue();
    }

    //하나 이상의 파라미터를 테스트에 넣고 싶을 때 MethodSource 사용
    public static Stream<Arguments> movableProvider() {
        return Stream.of(
                Arguments.of(true, 1),
                Arguments.of(false, 0)
        );
    }

}