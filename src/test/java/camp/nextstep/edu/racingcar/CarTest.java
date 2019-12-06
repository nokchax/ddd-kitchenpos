package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarTest {

    private static final Logger log = LoggerFactory.getLogger(CarTest.class);

    @DisplayName("자동차 이름은 5글자 미만이어야만 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a","ab","abc","abcd","agdqw"})
    public void 자동차_이름_5글자_이하_정상생성(final String name){
        //given
            log.info("자동차 이름 {}",name);

        //when
            Car car = new Car(name);

        //then
            assertThat(name.length()).isLessThanOrEqualTo(5);
            assertThat(car).isNotNull();
            assertThat(car.isInPosition(0)).isTrue();
    }

    @DisplayName("자동차 이름이 5글자가 넘는 경우 익셉션이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abqweqwe","sdagfdg","wertfs","werdfgbdfgd"})
    public void 자동차_이름_5글자_초과_익셉션발생(final String name){
        //given
            log.info("자동차 이름 {}",name);

        //when
            assertThatThrownBy(()->{
                new Car(name);
            })
        //then
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 널이면 익셉션이 발생한다.")
    @ParameterizedTest
    @NullSource
    public void 자동차_이름_널_익셉션발생(final String name){
        //given
            log.info("name : {}",name);

        //when
            assertThatThrownBy(()->{
                new Car(name);
            })
        //then
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> moveArguments(){
        return Stream.of(
                Arguments.of(true),
                Arguments.of(false)
        );
    }

    @DisplayName("자동차는 이동전략에 따라 움직이거나 움직이지 않는다.")
    @ParameterizedTest
    @MethodSource("moveArguments")
    public void 자동차_이동(boolean isMove){
    //given
        String name = "name";
        int originPosition = 1;
        Car car = new Car(name,originPosition);

    //when
        car.move(()->isMove);

    //then
        if(isMove){
            assertThat(car.isInPosition(++originPosition)).isTrue();
            return;
        }
        assertThat(car.isInPosition(originPosition)).isTrue();

    }
}
