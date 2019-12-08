package camp.nextstep.edu.racingcar;

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
public class RandomMovingStrategyTest {

    @Mock
    private Random random;

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7})
    void _randomValueTest(int randomNumber) {

        // given
        given(random.nextInt(anyInt()))
                .willReturn(randomNumber);

        // when
        MovingStrategy movingStrategy = new RandomMovingStrategy(random);
        final boolean movable = movingStrategy.movable();

        // then
        assertThat(movable).isEqualTo(randomNumber >= 4);
    }
}
