package com.tot.query;

/**
 * Sql limit 定义封装
 */
public class Limit {
    /**
     * limit from index
     */
    private Integer from;
    /**
     * max result count
     */
    private Integer count;

    // get and set

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public void check(){
        if (from != null && from < 0) {
            throw new IllegalStateException("from不能小于0");
        }
        if(count != null && count <1){
            throw new IllegalStateException("from不能小于1");
        }
    }
}
