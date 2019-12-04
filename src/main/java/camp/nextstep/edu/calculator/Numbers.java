package camp.nextstep.edu.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private List<Integer> numbers;

    //boxed() -> primitive type을 reference type으로 박싱해서 stream을 생성함.
    Numbers(String[] numbers) {
        this.numbers = Arrays.stream(numbers)
                .map(this::parseInt)
                .collect(Collectors.toList());
    }
    
    private Integer parseInt(String number) {
        Integer parsedInt = Integer.parseInt(number);
        
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
