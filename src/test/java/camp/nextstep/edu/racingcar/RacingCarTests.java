package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RacingCarTests {

    @Mock
    private Random random;

    @DisplayName("자동차 이름 (5글자 이내) 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"blue", "red", "green"})
    void carNormalNameTest(String input) {
        assertThat(new Car(input));
    }

    @DisplayName("자동차 이름 (5글자 초과) 테스트")
    @Test
    void carAbnormalNameOverTest() {
        assertThatThrownBy(() -> {
            new Car("abcdef");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 (NULL) 테스트")
    @Test
    void carAbnormalNameNullTest() {
        assertThatThrownBy(() -> {
            new Car(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 (NULL) @NullSource 테스트")
    @ParameterizedTest
    @NullSource
    void carAbnormalNameTest(String input) {
        assertThatThrownBy(() -> {
            new Car(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    @DisplayName("자동차 움직임 테스트")
    void carMovingTest(boolean result) {
        MovingStrategy mockMovingStrategy = mock(MovingStrategy.class);
        when(mockMovingStrategy.movable()).thenReturn(result);

        Car car = new Car("test");
        car.move(mockMovingStrategy);
        assertTrue(car.isInPosition(expectedPosition(result)));
    }

    @DisplayName("무작위 값이 4 이상이면 움직이고, 작으면 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @ExtendWith(MockitoExtension.class)
    void carRandomMovingTest(Integer randomNumber) {
        given(random.nextInt(anyInt()))
                .willReturn(randomNumber);

        MovingStrategy movingStrategy = new RandomMovingStrategy(random);
        Car car = new Car("test");
        car.move(movingStrategy);
        assertThat(car.isInPosition(expectedPosition(randomNumber)));
    }

    private int expectedPosition(boolean moveResult) {
        return moveResult ? 1 : 0;
    }

    private int expectedPosition(int randomNumber) {
        return randomNumber >= 4 ? 1 : 0;
    }


}
