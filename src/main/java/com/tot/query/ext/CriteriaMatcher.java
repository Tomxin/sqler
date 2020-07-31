package com.tot.query.ext;

public interface CriteriaMatcher {
    boolean match(Object data,Criteria<Object> criteria);
}
