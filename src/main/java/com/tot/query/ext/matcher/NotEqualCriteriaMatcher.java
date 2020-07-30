package com.tot.query.ext.matcher;

import com.tot.query.ext.Criteria;
import com.tot.query.ext.CriteriaGroup;

public class NotEqualCriteriaMatcher extends EqualCriteriaMatcher {

    @Override
    public CriteriaGroup.Operator supportOperate() {
        return CriteriaGroup.Operator.NOT_EQ;
    }

    @Override
    public boolean match(Object data, Criteria<Object> criteria) {
        return !super.match(data,criteria);
    }
}
