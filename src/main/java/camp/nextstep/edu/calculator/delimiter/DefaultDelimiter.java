package camp.nextstep.edu.calculator.delimiter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DefaultDelimiter implements Delimiter {

    private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile("[,:]");

    @Override
    public List<String> split(String text) {
        
        if (DEFAULT_DELIMITER_PATTERN.matcher(text).find()) {
            return Arrays.stream(text.split(DEFAULT_DELIMITER_PATTERN.pattern()))
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

}
