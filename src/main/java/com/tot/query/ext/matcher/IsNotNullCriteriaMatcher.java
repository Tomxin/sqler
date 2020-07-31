package com.tot.query.ext.matcher;

import com.tot.query.ext.Criteria;
import com.tot.query.ext.CriteriaGroup;
import com.tot.query.ext.CriteriaMatcher;
import com.tot.util.FieldUtil;

public class IsNotNullCriteriaMatcher implements CriteriaMatcher {

    @Override
    public boolean match(Object data, Criteria<Object> criteria) {
        Object fieldData = FieldUtil.getFieldValueByName(criteria.getFieldName(), data);
        return fieldData != null;
    }
}
