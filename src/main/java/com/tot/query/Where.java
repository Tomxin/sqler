package com.tot.query;

import com.tot.query.ext.CriteriaGroup;

import java.util.ArrayList;
import java.util.List;

public class Where {

    private List<CriteriaGroup> criteriaGroups = new ArrayList<>();

    public static  Where newInstance(){
        return new Where();
    }

    public CriteriaGroup init(){
        CriteriaGroup instance = CriteriaGroup.instance(CriteriaGroup.LogicEnum.AND);
        criteriaGroups.add(instance);
        return instance;
    }

    public CriteriaGroup andGroup(){
        CriteriaGroup instance = CriteriaGroup.instance(CriteriaGroup.LogicEnum.AND);
        criteriaGroups.add(instance);
        return instance;
    }

    public CriteriaGroup orGroup(){
        CriteriaGroup instance = CriteriaGroup.instance(CriteriaGroup.LogicEnum.OR);
        criteriaGroups.add(instance);
        return instance;
    }

    public List<CriteriaGroup> getCriteriaGroups() {
        return criteriaGroups;
    }

    public void setCriteriaGroups(List<CriteriaGroup> criteriaGroups) {
        this.criteriaGroups = criteriaGroups;
    }
}
