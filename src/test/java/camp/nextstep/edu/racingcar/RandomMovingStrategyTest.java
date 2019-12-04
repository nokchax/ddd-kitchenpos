package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class RandomMovingStrategyTest {

    @Mock
    private Random random;

    @DisplayName("0에서 9 사이의 무작위 값을 구한 후, 무작위 값이 4 이상인 경우 true 아니면 false를 리턴")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 9})
    public void testCondition(int randomNumber) {
        //given
        given(random.nextInt(anyInt()))
                .willReturn(randomNumber);

        //when
        MovingStrategy movingStrategy = new RandomMovingStrategy(random);
        final boolean movable = movingStrategy.movable();

        //then
        assertThat(movable).isEqualTo(randomNumber >= 4);
    }


}