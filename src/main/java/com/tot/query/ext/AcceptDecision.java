package com.tot.query.ext;

/**
 * Created by TOT on 2017/3/25.
 */
@FunctionalInterface
public interface AcceptDecision<V> {
    /**
     * 是否接收value值，不接受返回false.接收返回true
     * @param value 需要判断的值value
     * @return 结果
     */
    boolean accept(V value);
}
