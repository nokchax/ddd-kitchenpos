package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private List<Integer> numbers;

    Numbers(String[] numbers) {
        this.numbers = Arrays.stream(numbers)
                .map(this::parseStringNumber)
                .collect(Collectors.toList());
    }
    
    private Integer parseStringNumber(String stringNumber) {
        Integer parsedInt = Integer.parseInt(stringNumber);
        
        if(parsedInt < 0)
            throw new RuntimeException();
        
        return parsedInt;
    }

    int sum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
