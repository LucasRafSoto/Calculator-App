package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import operand.Operand;

public class OperandTest {
    @Test
    void testCheck() {
        ArrayList<String> validOperands = 
            new ArrayList<>(Arrays.asList( "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" ));

        validOperands.forEach(operand -> assertTrue(Operand.check(operand)));
        assertFalse(Operand.check("a"));
    }

    @Test
    void testGetValueFromOriginalString() {
        Operand operandOne = new Operand("3");
        assertEquals(3, operandOne.getValue());
    }
    
    @Test
    void testGetValueFromOriginalInt() {
        Operand operandTwo = new Operand(7);
        assertEquals(7, operandTwo.getValue());
    }
}
