package camp.nextstep.edu.calculator;

import camp.nextstep.edu.calculator.delimiter.CustomDelimiter;
import camp.nextstep.edu.calculator.delimiter.DefaultDelimiter;
import camp.nextstep.edu.calculator.delimiter.Delimiter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGroupParser {


    private final List<Delimiter> delimiters;

    public NumberGroupParser() {
        this.delimiters = new ArrayList<>();
        this.delimiters.add(new DefaultDelimiter());
        this.delimiters.add(new CustomDelimiter());
    }

    public List<Integer> parse(String text) {

        for (Delimiter delimiter : delimiters) {
            final List<String> split = delimiter.split(text);
            if (!split.isEmpty()) {
                return toNumberGroup(split);
            }
        }

        return toNumberGroup(Collections.singletonList(text));
    }

    private List<Integer> toNumberGroup(List<String> split) {
        return split.stream()
                .map(this::parseInt)
                .collect(Collectors.toList());
    }

    private Integer parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다");
        }
    }

}
