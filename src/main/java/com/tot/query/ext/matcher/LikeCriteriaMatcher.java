package com.tot.query.ext.matcher;

import com.tot.query.ext.Criteria;
import com.tot.query.ext.CriteriaMatcher;
import com.tot.util.FieldUtil;

public class LikeCriteriaMatcher implements CriteriaMatcher {

    @Override
    public boolean match(Object data, Criteria<Object> criteria) {

        Object fieldData = FieldUtil.getFieldValueByName(criteria.getFieldName(), data);
        if (fieldData instanceof String) {
            // todo 暂未实现 %% 相关匹配
            String likeEx = criteria.getValue().toString();
            return fieldData.toString().contains(likeEx);
        } else {
            throw new IllegalArgumentException("Like only support Field Type:String");
        }
    }
}
