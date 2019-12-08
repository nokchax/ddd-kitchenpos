package camp.nextstep.edu.racingcar;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{

    private Random random;

    public RandomMovingStrategy(final Random random){
        this.random = random;
    }

    public boolean movable() {
        return random.nextInt(9) >= 4;
    }
}
