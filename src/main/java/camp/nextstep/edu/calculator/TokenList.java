package camp.nextstep.edu.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TokenList {

    private final List<String> tokenList = new ArrayList<>();

    private TokenList(){}

    private TokenList(final List<String> list){
        tokenList.addAll(list);
    }

    // 팩토리 메소드
    static TokenList create(){
        return new TokenList();
    }

    // 팩토리 메소드 : 컬렉션으로 변환하기 위함
    static TokenList createOf(final String[] array){
        return new TokenList(Arrays.asList(array));
    }

    static TokenList createOf(final List<String> list) {
        return new TokenList(list);
    }

    void addAll(final List<String> list) {
        tokenList.addAll(list);
    }

    Iterator<String> iterator() {
        return tokenList.iterator();
    }
}
