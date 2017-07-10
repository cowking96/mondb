package com.cowking96.mondb.util;

import com.cowking96.mondb.model.Monster;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class EncounterBuilderResult {

    private Iterable<Monster> encounterMonsterList;
    private int[][] xpTable;

    public Iterable<Monster> getEncounterMonsterList() {
        return encounterMonsterList;
    }

    public void setEncounterMonsterList(Iterable<Monster> encounterMonsterList) {
        this.encounterMonsterList = encounterMonsterList;
    }

    public int[][] getXpTable() {
        return xpTable;
    }

    public void setXpTable(int[][] xpTable) {
        this.xpTable = xpTable;
    }

}
