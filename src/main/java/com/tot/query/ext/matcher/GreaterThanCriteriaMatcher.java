package com.tot.query.ext.matcher;

import com.tot.query.ext.Criteria;
import com.tot.query.ext.CriteriaMatcher;
import com.tot.util.FieldUtil;

public class GreaterThanCriteriaMatcher implements CriteriaMatcher {


    @Override
    public boolean match(Object data, Criteria<Object> criteria) {
        Object fieldData = FieldUtil.getFieldValueByName(criteria.getFieldName(), data);
        if (!(fieldData instanceof Comparable)) {
            throw new IllegalArgumentException("GT only support Comparable Field");
        }
        return ((Comparable) fieldData).compareTo(criteria.getOperator()) > 0;
    }


}
