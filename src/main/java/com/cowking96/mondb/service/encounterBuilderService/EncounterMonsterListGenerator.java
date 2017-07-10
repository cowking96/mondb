package com.cowking96.mondb.service.encounterBuilderService;

import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;

import java.util.List;

public interface EncounterMonsterListGenerator {

    Iterable<Monster> generateEncounterList(List<MonsterType> types, int minXp, int maxXp);
}
