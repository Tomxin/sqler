package com.tot.query;

/**
 * Sql limit 定义封装
 */
public class Limit {
    /**
     * limit from index
     */
    private int from;
    /**
     * max result count
     */
    private int count;

    // get and set

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
