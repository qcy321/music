package com.mu.util;

public class ResultPage {
    private int offset;
    private int limit;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "ResultPage{" +
                "offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}
