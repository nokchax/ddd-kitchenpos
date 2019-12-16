package camp.nextstep.edu.racingcar;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

public class CarTests {

    @DisplayName("자동차 생성(이름), 이름이 5자 초과, 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"가나다라마바", "ABCDEF", "123456"})
    public void testNewCarWithCarName(String carName) {
        assertThrows(IllegalArgumentException.class, () -> new Car(carName));
    }

    @DisplayName("자동차 생성(이름,포지션) , 이름이 5자 초과, 예외발생")
    @ParameterizedTest
    @CsvSource({"가나다라마바, 1", "ABCDEF, 1", "123456 , 1"})
    public void testNewCarWithCarNameAndPosition(String carName, int position) {
        assertThrows(IllegalArgumentException.class, () -> new Car(carName, position));
    }

    @DisplayName("자동차 이동, 이동 전략이 True 인 경우")
    @Test
    public void testCarMovingWhenStrategyIsTrue() {
        final int beforePosition = 0;
        final Car car = new Car("Car", beforePosition);

        car.move(getMockMovingStrategy(true));

        assertFalse(car.isInPosition(beforePosition));
    }

    @DisplayName("자동차 이동, 이동 전략이 False 인 경우")
    @Test
    public void testCarMovingWhenStrategyIsFalse() {
        final int beforePosition = 0;
        final Car car = new Car("Car", beforePosition);

        car.move(getMockMovingStrategy(false));

        assertTrue(car.isInPosition(beforePosition));
    }

    private RandomMovingStrategy getMockMovingStrategy(boolean movable) {
        final RandomMovingStrategy mockMovingStrategy = Mockito.mock(RandomMovingStrategy.class);
        Mockito.when(mockMovingStrategy.movable()).thenReturn(movable);

        return mockMovingStrategy;
    }
}
