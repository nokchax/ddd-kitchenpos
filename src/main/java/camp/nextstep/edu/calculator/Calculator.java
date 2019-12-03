package camp.nextstep.edu.calculator;

public class Calculator {

    int add(String input) throws RuntimeException {
        if(input == null || input.isEmpty())
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
}
