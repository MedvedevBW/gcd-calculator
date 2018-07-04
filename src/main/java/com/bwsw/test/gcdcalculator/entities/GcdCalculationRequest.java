package com.bwsw.test.gcdcalculator.entities;

public class GcdCalculationRequest {
    private Long id;
    private int firstNumber;
    private int secondNumber;

    public GcdCalculationRequest(Long id, int firstNumber, int secondNumber) {
        this.id = id;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }


    public Long getId() {
        return id;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }
}
