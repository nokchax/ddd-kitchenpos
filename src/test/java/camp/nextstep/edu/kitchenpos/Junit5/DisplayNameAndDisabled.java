package camp.nextstep.edu.kitchenpos.Junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DisplayNameAndDisabled {
    @DisplayName("Single test successful")
    @Test
    void testSingleSuccessTest() {
        System.out.println("Test success");
    }

    @Disabled("Not implemented yet")
    @Test
    void testShowSomething() {
    }
}
