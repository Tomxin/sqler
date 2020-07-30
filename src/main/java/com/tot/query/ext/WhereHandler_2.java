package com.tot.query.ext;

import com.tot.query.Where;
import com.tot.util.FieldUtil;

import java.util.EnumMap;

public class WhereHandler_2 {
    private static EnumMap<CriteriaGroup.Operator,OperatorHandler> criteriaHandlerMap = new EnumMap<>(CriteriaGroup.Operator.class);

    /**
     *
     * @param data 数据-类比数据的一行
     * @param where 条件
     * @return data根据条件过滤返回的结果，若匹配返回true,不匹配返回false
     */
    public boolean isMatch(Object data, Where where){

        Boolean match = null;
        for (CriteriaGroup criteriaGroup : where.getCriteriaGroups()) {
            // 跳过空条件组
            if(criteriaGroup.getCriteriaList() == null || criteriaGroup.getCriteriaList().size() == 0){
                continue;
            }
            if (criteriaGroup.getGroupType() == null) {
                throw new IllegalArgumentException("GroupType can not be null");
            }
            if (match == null) {
                match = dataGroupMatch(data,criteriaGroup);
            }
            if (CriteriaGroup.LogicEnum.OR.equals(criteriaGroup.getGroupType())) {
                if(match){
                    return true;
                } else {
                    match = dataGroupMatch(data,criteriaGroup);
                }
            } else if(CriteriaGroup.LogicEnum.AND.equals(criteriaGroup.getGroupType())){
                if(match){
                    match = dataGroupMatch(data,criteriaGroup);
                }
            }
        }
        // match == null 则默认返回true
        return match == null || match;
    }

    private boolean dataGroupMatch(Object data,CriteriaGroup criteriaGroup){

        Boolean match = null;

        // AND 优于 OR运算
        // and将左右的条件组合成一个组，而or会将两边拆成不同的组。以下面条件为例
        // 1 = 2 and 2=2 or 1=1 or 3=4 and 5=5 or 1=2被拆分结果如下：
        // (1 = 2 and 2=2) or (1=1) or (3=4 and 5=5) or (1=2)
        //只要一个组里面的结果为true，则返回结果为true，否则为false
        for (Criteria criteria : criteriaGroup.getCriteriaList()) {
            // 第一个条件
            if (criteria.getLogic() == null) {
                throw new IllegalArgumentException("LogicEnum can not be null");
            }
            if (match == null) {
                match = dataMatch(data,criteria);
                continue;
            }
            if(CriteriaGroup.LogicEnum.OR.equals(criteria.getLogic())){
                if (match) {
                    return true;
                } else {
                    match = dataMatch(data,criteria);
                }
            } else if(CriteriaGroup.LogicEnum.AND.equals(criteria.getLogic())){
                if(!match){
                    continue;
                } else {
                    match = dataMatch(data,criteria);
                }
            }
        }
        return match;
    }

    private boolean dataMatch(Object data,Criteria criteria){
        // todo impl
        // 数据校验和获取
        // 要求，数据比较的类型必须相同
        String fieldName = criteria.getFieldName();
        Object dataValue = FieldUtil.getFieldValueByName(fieldName, data);
//        if (!dataValue.getClass().equals(criteria.getValue().getClass())) {
//            throw new IllegalArgumentException(String.format("type mismatch[%s<-->%s]",data.getClass(),criteria.getValue().getClass()));
//        }
        // 比较逻辑
        return true;
    }
}
