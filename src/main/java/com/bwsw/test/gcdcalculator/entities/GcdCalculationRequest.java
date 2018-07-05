package com.bwsw.test.gcdcalculator.entities;

import java.io.Serializable;

public final class GcdCalculationRequest implements Serializable {
    private long first;
    private long second;
    private long id;

    public GcdCalculationRequest() {}

    public GcdCalculationRequest(long first, long second, long id) {
        this.first = first;
        this.second = second;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getSecond() {
        return second;
    }

    public long getFirst() {
        return first;
    }

    public void setFirst(long first) {
        this.first = first;
    }

    public void setSecond(long second) {
        this.second = second;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String toString() {
        return "GcdCalculationRequest( id: " + id +
                ", first: " + first + ", second: " + second + ")";
    }
}
