package com.bwsw.test.gcdcalculator.entities;

import java.io.Serializable;

public final class GcdCalculationResponse implements Serializable {
    private long requestId;
    private long result;
    private String errorMessage;

    public GcdCalculationResponse(long requestId, long result) {
        this.requestId = requestId;
        this.result = result;
    }

    public GcdCalculationResponse(long requestId, String errorMessage) {
        this.requestId = requestId;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public long getResult() {
        return result;
    }

    public long getRequestId() {
        return requestId;
    }

    public String toString() {
        return "GcdCalculationResponse( requestId: " + requestId +
                ", result: " + result + ", errorMessage: " + errorMessage + ")";
    }
}
