package com.tot.query;

import java.util.List;

/**
 * group 限制
 */
public class GroupBy {

    /**
     * group by 列定义，可以多个
     */
    private List<String> cols;

    public List<String> getCols() {
        return cols;
    }

    public void setCols(List<String> cols) {
        this.cols = cols;
    }
}
