package com.tot.query.ext.matcher;

import com.tot.query.ext.Criteria;
import com.tot.query.ext.CriteriaGroup;
import com.tot.query.ext.CriteriaMatcher;
import com.tot.util.FieldUtil;

public class NotLikeCriteriaMatcher extends LikeCriteriaMatcher {
    @Override
    public boolean match(Object data, Criteria<Object> criteria) {
       return !super.match(data,criteria);
    }
}
