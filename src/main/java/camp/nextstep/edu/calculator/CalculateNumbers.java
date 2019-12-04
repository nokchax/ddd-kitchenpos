package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CalculateNumbers {
    private List<Integer> calculateNumbers = new ArrayList<>();

    public CalculateNumbers(String[] strings) {
        addAll(strings);
        validateNumberValue();
    }

    public int sum() {
        return calculateNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void validateNumberValue() {
        final boolean containsNegativeValue = calculateNumbers.stream()
                .anyMatch(number -> number < 0);
        if (containsNegativeValue) {
            throw new RuntimeException("음수값이 들어왔습니다.");
        }
    }

    private void addAll(String[] numberStrings) {
        calculateNumbers.addAll(convertStringArrayToNumberList(numberStrings));
    }

    private List<Integer> convertStringArrayToNumberList(String[] numberStrings) {
        try {
            return Arrays.stream(numberStrings)
                    .map(Integer::parseInt)
                    .collect(toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

}
