package com.tot.query.ext.matcher;

import com.tot.query.ext.Criteria;
import com.tot.query.ext.CriteriaMatcher;
import com.tot.util.FieldUtil;

import java.util.Objects;

public class EqualCriteriaMatcher implements CriteriaMatcher {

    @Override
    public boolean match(Object data, Criteria<Object> criteria) {
        Object fieldData = FieldUtil.getFieldValueByName(criteria.getFieldName(), data);
        return Objects.equals(fieldData,criteria.getValue());
    }

}
