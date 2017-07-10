package com.cowking96.mondb.util;

import com.cowking96.mondb.model.MonsterType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EncounterBuilderInfo {


    private static final int PARTY_SIZE_1_2 = 0;
    private static final int PARTY_SIZE_3_5 = 1;
    private static final int PARTY_SIZE_6 = 2;


    private Integer partySize;
    private Integer partyLevel;
    private String type;

    public Integer getPartySize() {
        return partySize;
    }

    public void setPartySize(Integer partySize) {
        this.partySize = partySize;
    }

    public Integer getPartyLevel() {
        return partyLevel;
    }

    public void setPartyLevel(Integer partyLevel) {
        this.partyLevel = partyLevel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "EncounterBuilderInfo{" +
                "partySize=" + partySize +
                ", partyLevel=" + partyLevel +
                ", type='" + type + '\'' +
                '}';
    }

    public List<MonsterType> convertTypeToEnum() {
        if (type.trim() == "") {
            return null;
        }
        String[] monsterTypesString = type.split("\\s+");
        List<MonsterType> monsterTypes = new ArrayList();
        for (String s : monsterTypesString) {
            monsterTypes.add(MonsterType.valueOf(s));
        }
        return monsterTypes;
    }

    public int convertPartySizeToindex(int partySize) {

        switch (partySize) {

            case 2:
                return PARTY_SIZE_1_2;

            case 5:
                return PARTY_SIZE_3_5;

            case 6:
                return PARTY_SIZE_6;
        }

        return 0;


    }
}
