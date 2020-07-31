package com.tot.query.ext.matcher;

import com.tot.query.ext.Criteria;
import com.tot.query.ext.CriteriaGroup;
import com.tot.query.ext.CriteriaMatcher;
import com.tot.util.FieldUtil;

public class LessThanOrEqCriteriaMatcher implements CriteriaMatcher {

    @Override
    public boolean match(Object data, Criteria<Object> criteria) {
        Object fieldData = FieldUtil.getFieldValueByName(criteria.getFieldName(), data);
        if (!(fieldData instanceof Comparable)) {
            throw new IllegalArgumentException("LTE only support Comparable Field");
        }
        return ((Comparable) fieldData).compareTo(criteria.getOperator()) <= 0;
    }
}
