package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import evaluator.Evaluator;

public class EvaluatorTest {
    @Test
    void testSimpleAddition() {
        Evaluator evaluator = new Evaluator();

        assertEquals(3, evaluator.eval("1 +2"));
    }

    @Test
    void testSimpleDivision() {
        Evaluator evaluator = new Evaluator();

        assertEquals(0, evaluator.eval("1/2"));
    }

    @Test
    void testSimpleExpression() {
        Evaluator evaluator = new Evaluator();

        assertEquals(7, evaluator.eval("1+2*3"));
    }

    @Test
    void testSimpleParenthesizedExpression() {
        Evaluator evaluator = new Evaluator();

        assertEquals(9, evaluator.eval("(1+2)*3"));
    }

    @Test
    void testComplexExpressionWithNegativeResult() {
        Evaluator evaluator = new Evaluator();

        assertEquals(-1, evaluator.eval("2-(3/10)+2-5"));
    }

    @Test
    void testAnotherComplexExpressionWithNegativeResult() {
        Evaluator evaluator = new Evaluator();

        assertEquals(-6, evaluator.eval("(6-12*2)/3"));
    }

    @Test
    void testSimpleExponentiation() {
        Evaluator evaluator = new Evaluator();

        assertEquals(9, evaluator.eval("3^2"));
    }

    @Test
    void testSlightlyMoreComplexExponentiation() {
        Evaluator evaluator = new Evaluator();

        assertEquals(4, evaluator.eval("3^2/2"));
    }

    @Test
    void testHardMode() {
        Evaluator evaluator = new Evaluator();

        assertEquals(1176, evaluator.eval("2+3-5*((2-3)*2-5*2+3*(2-3-5-5*6)+4/2)*2-9"));
    }

    @Test
    void testProperStackUsage() {
        Evaluator evaluator = new Evaluator();

        // Stacks should be emptied and in a valid state after the first evaluation
        // occurs,
        // so the second evaluation should run without exception and provide
        assertEquals(6, evaluator.eval("1+2+3"));
        assertEquals(1, evaluator.eval("10-8-1"));
    }
}
