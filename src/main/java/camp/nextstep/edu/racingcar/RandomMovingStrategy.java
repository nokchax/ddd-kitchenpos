package camp.nextstep.edu.racingcar;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private Random random;

    public RandomMovingStrategy(Random random) {
        this.random = random;
    }
    @Override
    public boolean movable() {
        random.setSeed(System.currentTimeMillis());
        return random.nextInt(9) >= 4;
    }
}
