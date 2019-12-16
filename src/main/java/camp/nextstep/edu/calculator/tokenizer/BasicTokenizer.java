package camp.nextstep.edu.calculator.tokenizer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicTokenizer implements Tokenizer {

    private static final String DEFAULT_PATTERN = "[,:]";

    @Override
    public List<String> split(String text) {

        return Arrays.stream(text.split(DEFAULT_PATTERN))
                .collect(Collectors.toList());
    }


}
