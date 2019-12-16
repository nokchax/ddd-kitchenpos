package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.tokenizer.Tokenizer;

import java.util.List;
import java.util.stream.Collectors;

public class NumberGroupParser {

    private final Tokenizer tokenizer;

    public NumberGroupParser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public List<Integer> parse(String text) {
        return toNumberGroup(tokenizer.split(text));
    }

    private List<Integer> toNumberGroup(List<String> numberStrings) {
        return numberStrings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
