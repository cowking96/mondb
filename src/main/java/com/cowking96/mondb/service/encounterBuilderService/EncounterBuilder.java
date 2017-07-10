package com.cowking96.mondb.service.encounterBuilderService;

import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.util.EncounterBuilderInfo;
import com.cowking96.mondb.util.EncounterBuilderResult;

public interface EncounterBuilder {

     EncounterBuilderResult createEncounter(Iterable <Monster> monsterList, int[][] xpTable);

}
