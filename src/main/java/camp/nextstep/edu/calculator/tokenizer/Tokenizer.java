package camp.nextstep.edu.calculator.tokenizer;

import java.util.List;

@FunctionalInterface
public interface Tokenizer {

    List<String> split(String text);
}
