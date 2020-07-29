package com.tot.query.ext;

/**
 * Created by TOT on 2017/3/25.
 */
public class BetweenBean {
    private Comparable begin;
    private Comparable end;
    public BetweenBean(Comparable begin,Comparable end){
        assert begin != null;
        assert end != null;
        this.begin = begin;
        this.end = end;
    }

    public Comparable getBegin() {
        return begin;
    }

    public void setBegin(Comparable begin) {
        this.begin = begin;
    }

    public Comparable getEnd() {
        return end;
    }

    public void setEnd(Comparable end) {
        this.end = end;
    }
}
