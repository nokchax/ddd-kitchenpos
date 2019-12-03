package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RacingCarTests {

    @DisplayName("자동차 이름 (5글자 이내) 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "blue", "red", "green" })
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

    @Test
    @DisplayName("자동차 움직임 테스트")
    // @Disabled("Not implemented yet")
    void carMovingTest() {
        MovingStrategy mockMovingStrategy = mock(MovingStrategy.class);
        when(mockMovingStrategy.movable()).thenReturn(true);

        Car car = new Car("test", 0);
        car.move(mockMovingStrategy);
        assertTrue(car.isInPosition(1));
    }

    @Test
    @DisplayName("자동차 정지 테스트")
    // @Disabled("Not implemented yet")
    void carNotMovingTest() {
        MovingStrategy mockMovingStrategy = mock(MovingStrategy.class);
        when(mockMovingStrategy.movable()).thenReturn(false);

        Car car = new Car("test", 0);
        car.move(mockMovingStrategy);
        assertFalse(car.isInPosition(1));
    }
}
