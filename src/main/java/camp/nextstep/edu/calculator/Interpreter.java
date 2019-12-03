package camp.nextstep.edu.calculator;

public class Interpreter {
    private Numbers numbers;

    static Interpreter of(String input) {
        Interpreter interpreter = new Interpreter();
        interpreter.numbers = new Numbers(input.split("([,:])"));

        return interpreter;
    }

    int calculate() throws RuntimeException {
        return this.numbers
                .sum();
    }
}
