package com.tot.query.ext;


import com.tot.util.StringUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by tot on 17-3-16.
 */
public class CriteriaGroup {

    public enum Operator {
        EQ, NOT_EQ, LIKE, NOT_LIKE, GT, LT, GTE, LTE, IS_NULL, NOT_NULL, IN, NOT_IN;
    }
    public enum LogicEnum {
        AND,
        OR;
    }

    private final static String NULL = "null";

    public static CriteriaGroup instance(LogicEnum logicEnum) {
        CriteriaGroup criteriaGroup = new CriteriaGroup();
        criteriaGroup.setGroupType(logicEnum);
        return criteriaGroup;
    }

    private LogicEnum groupType;

    public LogicEnum getGroupType() {
        return groupType;
    }

    public void setGroupType(LogicEnum groupType) {
        this.groupType = groupType;
    }

    private List<Criteria> criteriaList = new ArrayList<>();

    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }


    private <V>CriteriaGroup andCriteria(Operator op, String fieldName, V value) {
        if(value == null || StringUtil.isBlank(value.toString())) {
            return this;
        }
        criteriaList.add(Criteria.andCriteria(op, fieldName, value));
        return this;
    }

    private <V>CriteriaGroup orCriteria(Operator op, String fieldName, V value) {
        if(value == null) {
            return this;
        }
        criteriaList.add(Criteria.orCriteria(op, fieldName, value));
        return this;
    }



    // --------------------------and-logic criteria---------------------------------------------------//

    public <V>CriteriaGroup andEqual(String fieldName, V value) {

        return andCriteria(Operator.EQ, fieldName, value);
    }

    public <V>CriteriaGroup andNotEqual(String fieldName, V value) {

        return andCriteria(Operator.NOT_EQ, fieldName, value);

    }

    public CriteriaGroup andLike(String fieldName, String value) {
        return andCriteria(Operator.LIKE, fieldName, handleLikeString(value));
    }
    public CriteriaGroup andPureLike(String fieldName, String value) {
        return andCriteria(Operator.LIKE, fieldName,value);
    }
    private String handleLikeString(String value){
        if(isBlank(value)){
            return null;
        }
        return "%"+value+"%";
    }

    public CriteriaGroup andNotLike(String fieldName, String value) {

        return andCriteria(Operator.NOT_LIKE, fieldName, handleLikeString(value));
    }
    public CriteriaGroup andPureNotLike(String fieldName, String value) {

        return andCriteria(Operator.NOT_LIKE, fieldName, value);
    }

    public <V extends Comparable>CriteriaGroup andGreaterThan(String fieldName, V value) {

        return andCriteria(Operator.GT, fieldName, value);
    }

    public <V extends Comparable>CriteriaGroup andGreaterThanOrEqual(String fieldName, V value) {

        return andCriteria(Operator.GTE, fieldName, value);
    }

    public <V extends Comparable>CriteriaGroup andLessThan(String fieldName, V value) {

        return andCriteria(Operator.LT, fieldName, value);
    }

    public <V extends Comparable>CriteriaGroup andLessThanOrEqual(String fieldName, V value) {

        return andCriteria(Operator.LTE, fieldName, value);
    }

    public CriteriaGroup andIsNull(String fieldName) {
        return andCriteria(Operator.IS_NULL, fieldName, NULL);
    }

    public CriteriaGroup andNotNull(String fieldName) {
        return andCriteria(Operator.NOT_NULL, fieldName, NULL);
    }

    public <V extends Collection> CriteriaGroup andIn(String fieldName, V values) {
        if (values == null || values.size() == 0) {
            return this;
        }
        return andCriteria(Operator.IN, fieldName, values);
    }

    public <V extends Collection> CriteriaGroup andNotIn(String fieldName, V values) {
        if (values == null || values.size() == 0) {
            return this;
        }
        return andCriteria(Operator.NOT_IN, fieldName, values);
    }



    //--------------------------------OR-OPERATION----------------------------------------------//
    // or-logic criteria

    public <V>CriteriaGroup orEqual(String fieldName, V value) {
        return orCriteria(Operator.EQ, fieldName, value);
    }

    public <V>CriteriaGroup orNotEqual(String fieldName, V value) {

        return orCriteria(Operator.NOT_EQ, fieldName, value);

    }

    public CriteriaGroup orLike(String fieldName, String value) {
        return orCriteria(Operator.LIKE, fieldName, handleLikeString(value));
    }
    public CriteriaGroup orPureLike(String fieldName, String value) {
        return orCriteria(Operator.LIKE, fieldName, value);
    }

    public CriteriaGroup orNotLike(String fieldName, String value) {
        return orCriteria(Operator.NOT_LIKE, fieldName, handleLikeString(value));
    }

    public CriteriaGroup orPureNotLike(String fieldName, String value) {
        return orCriteria(Operator.NOT_LIKE, fieldName, value);
    }

    public <V extends Comparable>CriteriaGroup orGreaterThan(String fieldName, V value) {

        return orCriteria(Operator.GT, fieldName, value);
    }

    public <V extends Comparable>CriteriaGroup orGreaterThanOrEqual(String fieldName, V value) {

        return orCriteria(Operator.GTE, fieldName, value);
    }

    public <V extends Comparable>CriteriaGroup orLessThan(String fieldName, V value) {

        return orCriteria(Operator.LT, fieldName, value);
    }

    public <V extends Comparable>CriteriaGroup orLessThanOrEqual(String fieldName, V value) {

        return orCriteria(Operator.LTE, fieldName, value);
    }

    public CriteriaGroup orIsNull(String fieldName) {
        return orCriteria(Operator.IS_NULL, fieldName, NULL);
    }

    public CriteriaGroup orIsNotNull(String fieldName) {
        return orCriteria(Operator.NOT_NULL, fieldName, NULL);
    }

    public <V extends Collection> CriteriaGroup orIsIn(String fieldName, V values) {
        if (values == null || values.size() == 0) {
            return this;
        }
        return orCriteria(Operator.IN, fieldName, values);
    }

    public <V extends Collection>CriteriaGroup orIsNotIn(String fieldName, V values) {

        if (values == null || values.size() == 0) {
            return this;
        }
        return orCriteria(Operator.NOT_IN, fieldName, values);

    }




    //--------------------------------OR-OPERATION----------------------------------------------//
    // or-logic criteria

    static boolean isBlank(String str){
        return str == null || "".equals(str.trim());
    }
    static boolean isNotBlank(String str){
        return !isBlank(str);
    }
}
