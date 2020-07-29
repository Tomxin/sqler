package com.tot.query.ext;

import com.tot.query.Where;


import java.util.Collection;
import java.util.EnumMap;

public class WhereHandler {
    private static EnumMap<CriteriaGroup.Operator,OperatorHandler> criteriaHandlerMap = new EnumMap<>(CriteriaGroup.Operator.class);
    static {
        criteriaHandlerMap.put(CriteriaGroup.Operator.EQ, Object::equals);
        criteriaHandlerMap.put(CriteriaGroup.Operator.NOT_EQ, (v1,v2)-> !v1.equals(v2));
        criteriaHandlerMap.put(CriteriaGroup.Operator.IS_NULL, (v1,v2)-> v1 == null);
        criteriaHandlerMap.put(CriteriaGroup.Operator.NOT_NOLL, (v1,v2)-> v1 != null);
        criteriaHandlerMap.put(CriteriaGroup.Operator.GT, new OperatorHandler<Comparable,Comparable>() {
            @Override
            public  boolean criteriaMatch(Comparable v1, Comparable v2) {
                return v1.compareTo(v1) > 0;
            }
        });


        criteriaHandlerMap.put(CriteriaGroup.Operator.GTE, new OperatorHandler<Comparable,Comparable>() {
            @Override
            public boolean criteriaMatch(Comparable v1, Comparable v2) {
                return v1.compareTo(v1) >= 0;
            }
        });

        criteriaHandlerMap.put(CriteriaGroup.Operator.LTE, new OperatorHandler<Comparable,Comparable>() {
            @Override
            public boolean criteriaMatch(Comparable v1, Comparable v2) {
                return v1.compareTo(v1) <= 0;
            }
        });


        criteriaHandlerMap.put(CriteriaGroup.Operator.IN, new OperatorHandler<Object, Collection>() {
            @Override
            public boolean criteriaMatch(Object v1, Collection v2) {
                return v2.contains(v1);
            }
        });

        criteriaHandlerMap.put(CriteriaGroup.Operator.IN, new OperatorHandler<Object, Collection>() {
            @Override
            public boolean criteriaMatch(Object v1, Collection v2) {
                return v2.contains(v1);
            }
        });

        criteriaHandlerMap.put(CriteriaGroup.Operator.BETWEEN, new OperatorHandler<Comparable, BetweenBean>() {
            @Override
            public boolean criteriaMatch(Comparable v1, BetweenBean v2) {
                return v2.getBegin().compareTo(v1) > 0 && v2.getEnd().compareTo(v1) < 0;
            }
        });

        criteriaHandlerMap.put(CriteriaGroup.Operator.BETWEEN, new OperatorHandler<Comparable, BetweenBean>() {
            @Override
            public boolean criteriaMatch(Comparable v1, BetweenBean v2) {
                return v2.getBegin().compareTo(v1) > 0 && v2.getEnd().compareTo(v1) < 0;
            }
        });

    }

    public boolean isMatch(Object data, Where where){

        for (CriteriaGroup criteriaGroup : where.getCriteriaGroups()) {


            for (Criteria criteria : criteriaGroup.getCriteriaList()) {

            }
        }
        return false;
    }
}
