package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CalculateNumbers {
    private List<Integer> calculateNumbers = new ArrayList<>();

    public CalculateNumbers(final String[] strings) {
        addAll(convertStringArrayToNumberList(strings));
    }

    public int sum() {
        return calculateNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void addAll(final List<Integer> numberStrings) {
        calculateNumbers.addAll(numberStrings);
    }

    private List<Integer> convertStringArrayToNumberList(final String[] numberStrings) {
        return Arrays.stream(numberStrings)
                .map(this::parseInt)
                .collect(toList());
    }

    private Integer parseInt(final String string) {
        final int num = Integer.parseInt(string);
        validateNumberValue(num);
        return num;
    }

    private void validateNumberValue(final int num) {
        if (num < 0) {
            throw new RuntimeException("음수값이 들어왔습니다.");
        }
    }
}
