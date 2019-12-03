package camp.nextstep.edu.calculator;

import org.springframework.util.StringUtils;

public class Calculator {

    int add(String input) throws RuntimeException {
        if(isEmpty(input))
            return 0;

        String[] nums = input.split("([,:])");

        int answer = 0;
        for(String num : nums) {
            try {
                int parsedNum = Integer.parseInt(num);

                if(parsedNum < 0)
                    throw new RuntimeException();

                answer += parsedNum;
            } catch (NumberFormatException e) {
                throw new RuntimeException();
            }
        }

        return answer;
    }

    private boolean isEmpty(String input) {
        return StringUtils.isEmpty(input);
    }
}
