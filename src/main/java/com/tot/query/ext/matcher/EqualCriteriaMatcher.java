package com.tot.query.ext.matcher;

import com.tot.query.ext.Criteria;
import com.tot.query.ext.CriteriaGroup;
import com.tot.query.ext.CriteriaMatcher;
import com.tot.util.FieldUtil;

import java.util.Objects;

public class EqualCriteriaMatcher implements CriteriaMatcher {
    @Override
    public CriteriaGroup.Operator supportOperate() {
        return CriteriaGroup.Operator.EQ;
    }

    @Override
    public boolean match(Object data, Criteria<Object> criteria) {
        if (!supportOperate().equals(criteria.getOperator())) {
            throw new IllegalStateException(String.format("not support operator:%s",criteria.getOperator()));
        }
        Object fieldData = FieldUtil.getFieldValueByName(criteria.getFieldName(), data);
        return Objects.equals(fieldData,criteria);
    }
}
