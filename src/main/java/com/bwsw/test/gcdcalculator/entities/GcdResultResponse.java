package com.bwsw.test.gcdcalculator.entities;

import java.io.Serializable;

public class GcdResultResponse implements Serializable {
    private Long id;
    private String errorMessage;
    private int result;

    public GcdResultResponse(Long id, String errorMessage) {
        this.id = id;
        this.errorMessage = errorMessage;
    }

    public GcdResultResponse(Long id, int result) {
        this.id = id;
        this.result = result;
    }
}
