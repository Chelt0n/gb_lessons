package com.example.lessonfirst;

import java.io.Serializable;

public class Counters implements Serializable {
    public String getCount() {
        return String.valueOf(count);
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count = 0;


}
