package calculator;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testAdd() {
        assertEquals(5, new Calculator().addIntegers(2,3));
    }

}
