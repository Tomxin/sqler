package com.tot.query.ext;

/**
 * Created by tot on 17-3-16.
 */
public class Criteria<V> {
    private CriteriaGroup.LogicEnum logic = CriteriaGroup.LogicEnum.AND;
    private CriteriaGroup.Operator operator;
    private String fieldName;
    private V value;

    private Criteria(CriteriaGroup.Operator operator, String fieldName, V value) {
        assert operator != null;
        assert fieldName != null;
        this.operator = operator;
        this.fieldName = fieldName;
        this.value = value;
    }


    static <V> Criteria<V> orCriteria(CriteriaGroup.Operator operator, String fieldName, V value){
        Criteria <V> criteria = new Criteria<>(operator, fieldName, value);
        criteria.setLogic(CriteriaGroup.LogicEnum.OR);
        return criteria;
    }

    static <V>Criteria<V> andCriteria(CriteriaGroup.Operator operator, String fieldName, V value){
        return new Criteria<>(operator, fieldName, value);
    }


    public CriteriaGroup.LogicEnum getLogic() {
        return logic;
    }

    public void setLogic(CriteriaGroup.LogicEnum logic) {
        this.logic = logic;
    }

    public CriteriaGroup.Operator getOperator() {
        return operator;
    }

    public void setOperator(CriteriaGroup.Operator operator) {
        this.operator = operator;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
