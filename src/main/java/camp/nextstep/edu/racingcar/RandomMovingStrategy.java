package camp.nextstep.edu.racingcar;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    boolean movable() {
        return new Random().nextInt(9) >= 4;
    }
}