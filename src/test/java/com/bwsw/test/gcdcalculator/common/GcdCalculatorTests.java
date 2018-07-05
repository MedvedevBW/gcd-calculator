package com.bwsw.test.gcdcalculator.common;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@SpringBootTest(classes = GcdCalculator.class)
public class GcdCalculatorTests extends AbstractTestNGSpringContextTests {
    @Test
    public void calculateGcd_will_return_result() {
        long firstArg = 12;
        long secondArg = 16;
        long result = GcdCalculator.calculateGcd(12, 16);
        long expectedResult = 4;

        assertEquals(result, expectedResult);
    }

    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void calculateGcd_will_throw_exception_if_one_of_arguments_is_not_positive() throws IllegalArgumentException {
        long negativeFirstArg = 0;
        long secondArg = 16;

        GcdCalculator.calculateGcd(negativeFirstArg, secondArg);
    }
}
