package kalkulator;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private static final double DELTA = 1e-15;

    @Test
    public void shouldAddPositiveIntegers() {
        double result= kalkulator.Calculator.add(12,23);
        Assert.assertEquals(35, result, DELTA);
    }
    @Test
    public void shouldAddPositiveNegativeIntegers() {
        double result= kalkulator.Calculator.add(12,-23);
        Assert.assertEquals(-11, result, DELTA);
    }

    @Test
    public void shouldSubPositivesIntegers() {
        double result= kalkulator.Calculator.sub(25,23);
        Assert.assertEquals(2, result, DELTA);
    }

    @Test
    public void shouldSubNegativesIntegers() {
        double result= kalkulator.Calculator.sub(-25,-23);
        Assert.assertEquals(-2, result, DELTA);
    }

    @Test
    public void shouldMultiply() {
        double result= kalkulator.Calculator.multiply(10,10);
        Assert.assertEquals(100, result, DELTA);
    }

    @Test
    @Ignore
    public void shouldDivide() {
        try {
            double result= kalkulator.Calculator.divide(10,0);
            Assert.assertEquals(1, result, DELTA);
        }
        catch(ArithmeticException ex){
            assertEquals("", ex.getMessage());
        }
    }
}