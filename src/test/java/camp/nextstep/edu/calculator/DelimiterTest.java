package camp.nextstep.edu.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DelimiterTest {

    private static final Logger log = LoggerFactory.getLogger(DelimiterTest.class);

    @DisplayName("구분자 , 로 문자열을 나눈다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4"})
    public void 구분자_콤마_문자열_나눔(final String text){
        //given
            log.info("text : {}",text);
        //when
            String[] separated = Delimiter.separate(text);
            String[] expected = {"1","2","3","4"};
        //then
            assertArrayEquals(separated,expected);
    }
    @DisplayName("구분자 ,와 ; 로 문자열을 나눈다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3,4:5"})
    public void 구분자_콤마_그리고_콜론_문자열_나눔(final String text){
        //given
            log.info("text : {}",text);
        //when
            String[] separated = Delimiter.separate(text);
            String[] expected = {"1","2","3","4","5"};
        //then
            assertArrayEquals(separated,expected);
    }
    @DisplayName("커스텀 구분자로 문자열을 나눈다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3;4;5"})
    public void 커스텀구분자_문자열_나눔(final String text){
        //given
            log.info("text : {}",text);
        //when
            String[] separated = Delimiter.separate(text);
            String[] expected = {"1","2","3","4","5"};
        //then
            assertArrayEquals(separated,expected);
    }
}