package com.cowking96.mondb.util;

import com.cowking96.mondb.model.MonsterType;

public class MonsterSearchInfo {
    private String name;
    private Float cr;
    private Integer xpValue;
    private String pageNumber;
    private MonsterType[] type;
    private String crComparison;

    public MonsterSearchInfo() {
        name = null;
        cr = null;
        xpValue = null;
        pageNumber = null;
        MonsterType[] type = null;
        crComparison = null;
    }

    public MonsterType[] getType() {
        return type;
    }

    public void setType(MonsterType[] type) {
        this.type = type;
    }

    public String getCrComparison() {
        return crComparison;
    }

    public void setCrComparison(String crComparison) {
        this.crComparison = crComparison;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCr(float cr) {
        this.cr = cr;
    }

    public void setXpValue(int xpValue) {
        this.xpValue = xpValue;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getName() {
        return name;
    }

    public Float getCr() {
        return cr;
    }

    public Integer getXpValue() {
        return xpValue;
    }

    public String getPageNumber() {
        return pageNumber;
    }

}
