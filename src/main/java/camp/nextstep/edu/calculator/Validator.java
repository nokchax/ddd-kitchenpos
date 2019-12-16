package camp.nextstep.edu.calculator;

public interface Validator {

    boolean isZeroIfNullOrEmpty(String line);

    int calculateIfPossibleOrElseThrow(String line);

}
