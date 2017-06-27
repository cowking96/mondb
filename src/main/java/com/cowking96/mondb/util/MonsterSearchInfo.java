package com.cowking96.mondb.util;

import com.cowking96.mondb.model.MonsterType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonsterSearchInfo {

    private String name;
    private Float cr;
    private Integer xpValue;
    private String pageNumber;
    private String type;
    private String crComparison;

    public MonsterSearchInfo() {
        name = null;
        cr = null;
        xpValue = null;
        pageNumber = null;
        crComparison = null;
        type = null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public void setCr(Float cr) {
        this.cr = cr;
    }

    public void setXpValue(Integer xpValue) {
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


//    @Override
//    public String toString() {
//        return "MonsterSearchInfo{" +
//                "name='" + name + '\'' +
//                ", cr=" + cr +
//                ", xpValue=" + xpValue +
//                ", pageNumber='" + pageNumber + '\'' +
//                ", type=" + Arrays.toString(type) +
//                ", crComparison='" + crComparison + '\'' +
//                '}';
//    }

    public List <MonsterType> convertToArray(String type) {
        if(type.trim() == ""){
            return null;
        }
        String[] monsterTypesString = type.split("\\s+");
       List<MonsterType> monsterTypes = new ArrayList();
        for(String s:monsterTypesString){
            monsterTypes.add(MonsterType.valueOf(s));
        }
        return monsterTypes;
    }
}
