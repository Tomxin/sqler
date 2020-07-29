package com.tot.query.ext;


@FunctionalInterface
public interface OperatorHandler<V1,V2> {

    /**
     * 条件匹配函数：v1是否和v2匹配
     * 匹配操作可选值为：{@link com.tot.query.ext.CriteriaGroup.Operator}
     * @param v1
     * @param v2
     * @return
     */
    boolean criteriaMatch(V1 v1,V2 v2);

}
