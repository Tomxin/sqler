package com.tot.query.ext;

public interface CriteriaMatcher {
    CriteriaGroup.Operator supportOperate();
    boolean match(Object data,Criteria<Object> criteria);
}
