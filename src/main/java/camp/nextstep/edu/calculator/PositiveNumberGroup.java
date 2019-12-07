package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.List;

public class PositiveNumberGroup {

    private final List<Integer> positiveNumbers = new ArrayList<>();

    public PositiveNumberGroup(List<Integer> numbers) {
        addAll(numbers);
    }

    private void addAll(List<Integer> numbers) {
        for (Integer number : numbers) {
            add(number);
        }
    }

    private void add(Integer number) {
        validate(number);
        this.positiveNumbers.add(number);
    }

    private void validate(Integer number) {
        if (number < 0) {
            throw new RuntimeException("숫자가 음수입니다");
        }
    }

    public int sumAll() {
        return positiveNumbers.stream()
                .reduce(0, Integer::sum);
    }
}
