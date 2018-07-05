package com.bwsw.test.gcdcalculator.common;

import java.math.BigInteger;

public class GcdCalculator {

    public static long calculateGcd(long firstNumber, long secondNumber) throws IllegalArgumentException {
        if (firstNumber <= 0 || secondNumber <= 0) {
            throw new IllegalArgumentException("Incorrect argument for GCD calculation");
        } else {
            BigInteger b1 = new BigInteger("" + firstNumber);
            BigInteger b2 = new BigInteger("" + secondNumber);
            BigInteger gcd = b1.gcd(b2);
            return gcd.longValue();
        }
    }
}
