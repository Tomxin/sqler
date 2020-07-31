package com.tot.query.ext.matcher;

import com.tot.query.ext.Criteria;
import com.tot.query.ext.CriteriaGroup;
import com.tot.query.ext.CriteriaMatcher;
import com.tot.util.FieldUtil;

import java.util.Collection;

public class NotInCriteriaMatcher implements CriteriaMatcher {

    @Override
    public boolean match(Object data, Criteria<Object> criteria) {
        if (!(criteria.getValue() instanceof Collection)) {
            throw new IllegalArgumentException("criteria value must be collection for NOT_IN operation");
        }
        Object fieldData = FieldUtil.getFieldValueByName(criteria.getFieldName(), data);
        return !((Collection) criteria.getValue()).contains(fieldData);
    }
}
