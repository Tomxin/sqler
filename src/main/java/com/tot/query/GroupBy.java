package com.tot.query;

import java.util.Set;

/**
 * group 限制
 */
public class GroupBy {

    /**
     * group by 列定义，可以多个
     */
    private Set<String> cols;

    public Set<String> getCols() {
        return cols;
    }

    public void setCols(Set<String> cols) {
        this.cols = cols;
    }
}
