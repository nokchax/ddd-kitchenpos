package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberList {
    private List<Integer> numbers = new ArrayList<>();

    public NumberList(String[] strings) {
        addAll(strings);
        validate();
    }

    private void validate() {
        final boolean containsNegativeValue = numbers.stream().anyMatch(number -> number < 0);
        if(containsNegativeValue){
            throw new RuntimeException("음수값이 들어왔습니다.");
        }
    }

    public int sum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    private void addAll(String[] numberStrings) {
        numbers.addAll(convertStringArrayToNumberList(numberStrings));
    }

    private List<Integer> convertStringArrayToNumberList(String[] numberStrings) {
        try {
            return Arrays.stream(numberStrings)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

}
