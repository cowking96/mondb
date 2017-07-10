package com.cowking96.mondb.util;

import com.cowking96.mondb.controller.MonsterSearchController;
import com.cowking96.mondb.model.MonsterType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonsterSearchInfo {

    private static final Logger LOG = LoggerFactory.getLogger(MonsterSearchInfo.class);

    private String name;
    private Float minCr;
    private Float maxCr;
    private String type;

    public MonsterSearchInfo() {
        name = null;
        minCr = null;
        maxCr = null;
        type = null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinCr(Float minCr) {
        this.minCr = minCr;
    }

    public void setMaxCr(Float maxCr) {
        this.maxCr = maxCr;
    }

    public String getName() {
        return name;
    }

    public Float getMinCr() {
        return minCr;
    }

    public Float getMaxCr() {
        return maxCr;
    }

    public List <MonsterType> convertTypeToEnum() {
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

    @Override
    public String toString() {
        return "MonsterSearchInfo{" +
                "name='" + name + '\'' +
                ", minCr=" + minCr +
                ", maxCr=" + maxCr +
                ", type='" + type + '\'' +
                '}';
    }
}
