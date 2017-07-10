package com.cowking96.mondb.service.encounterBuilderService;

import com.cowking96.mondb.dao.MonsterRepository;
import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;
import com.cowking96.mondb.service.MonsterPredicateBuilder;
import com.cowking96.mondb.service.encounterBuilderService.EncounterBuilder;
import com.cowking96.mondb.util.EncounterBuilderInfo;
import com.cowking96.mondb.util.EncounterBuilderResult;
import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class EncounterBuilderImpl implements EncounterBuilder {


    private MonsterRepository monsterRepository;
    private MonsterPredicateBuilder predicateBuilder;
    private EncounterMonsterListGeneratorImpl encounterMonsterListGenerator;
    private EncounterBuilderInfo encounterBuilderInfo;
    private Min_Max_Xp_CalculatorImpl min_max_xp_calculator;
    private XpTableBuilderImpl xpTableBuilder;


    @Autowired
    public EncounterBuilderImpl(MonsterRepository monsterRepository, MonsterPredicateBuilder predicateBuilder ) {
        this.monsterRepository = monsterRepository;
        this.predicateBuilder = predicateBuilder;
        this.encounterMonsterListGenerator = encounterMonsterListGenerator;
        this.encounterBuilderInfo = encounterBuilderInfo;
        this.min_max_xp_calculator = min_max_xp_calculator;
        this.xpTableBuilder = xpTableBuilder;
    }

    public EncounterBuilderResult createEncounter(Iterable <Monster> monsterList, int[][] xpTable) {
        EncounterBuilderResult encounterBuilderResult = new EncounterBuilderResult();
        encounterBuilderResult.setEncounterMonsterList(monsterList);
        encounterBuilderResult.setXpTable(xpTable);
        return encounterBuilderResult;
    }



}
