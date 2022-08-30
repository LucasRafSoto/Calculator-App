package tests;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;

import operator.Operator;

public class OperatorTest {
    @Test
    void testCheck() {
        ArrayList<String> validOperators = 
            new ArrayList<>(Arrays.asList( "+", "-", "*", "/", "^" ));

        validOperators.forEach(operator -> assertTrue(Operator.check(operator)));
        assertFalse(Operator.check("1"));
    }
}
