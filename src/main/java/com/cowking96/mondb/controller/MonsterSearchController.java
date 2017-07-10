package com.cowking96.mondb.controller;

import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;
import com.cowking96.mondb.service.encounterBuilderService.EncounterBuilder;
import com.cowking96.mondb.service.encounterBuilderService.EncounterMonsterListGeneratorImpl;
import com.cowking96.mondb.service.encounterBuilderService.Min_Max_Xp_CalculatorImpl;
import com.cowking96.mondb.service.encounterBuilderService.XpTableBuilderImpl;
import com.cowking96.mondb.util.ControllerError;
import com.cowking96.mondb.util.EncounterBuilderInfo;
import com.cowking96.mondb.util.EncounterBuilderResult;
import com.cowking96.mondb.util.MonsterSearchInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cowking96.mondb.service.MonsterService;

import java.util.List;

@RestController
public class MonsterSearchController {

    private static final Logger LOG = LoggerFactory.getLogger(MonsterSearchController.class);

    @Autowired
    private MonsterService monsterService;
    private EncounterBuilder encounterBuilder;
    private EncounterMonsterListGeneratorImpl encounterMonsterListGenerator;
    private EncounterBuilderInfo encounterBuilderInfo;
    private Min_Max_Xp_CalculatorImpl min_max_xp_calculator;
    private XpTableBuilderImpl xpTableBuilder;
    private EncounterBuilderResult encounterBuilderResult;

    @Autowired
    public MonsterSearchController(MonsterService monsterService,EncounterBuilder encounterBuilder,EncounterMonsterListGeneratorImpl encounterMonsterListGenerator
    ,EncounterBuilderInfo encounterBuilderInfo,Min_Max_Xp_CalculatorImpl min_max_xp_calculator,XpTableBuilderImpl xpTableBuilder,EncounterBuilderResult encounterBuilderResult){
    this.monsterService = monsterService;
    this.encounterBuilder = encounterBuilder;
    this.encounterMonsterListGenerator = encounterMonsterListGenerator;
    this.encounterBuilderInfo  = encounterBuilderInfo;
    this.min_max_xp_calculator = min_max_xp_calculator;
    this.xpTableBuilder = xpTableBuilder;
    this.encounterBuilderResult = encounterBuilderResult;
    }


    @RequestMapping(value = "/monsters",method = RequestMethod.POST)
    public ResponseEntity<?> searchForMonsters(MonsterSearchInfo monsterSearchInfo,XpTableBuilderImpl xpTableBuilder,EncounterBuilderResult encounterBuilderResult) {

        try {

            LOG.debug("The monster search function has been called with search info: {}", monsterSearchInfo.toString());
            Iterable<Monster> monsters = monsterService.findMonsters(monsterSearchInfo);

            LOG.debug(monsterSearchInfo.toString());

            return new ResponseEntity<Iterable<Monster>>(monsters, HttpStatus.OK);

        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<ControllerError>(new ControllerError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/monsters/encounterBuilder",method = RequestMethod.POST)
    public ResponseEntity<?> buildEncounter (EncounterBuilderInfo encounterBuilderInfo) {

        try {

            LOG.debug("The encounter builder function has been called with search info: {}", encounterBuilderInfo.toString());


            List<MonsterType> types = encounterBuilderInfo.convertTypeToEnum();
            EncounterBuilderResult encounterBuilderResult = new EncounterBuilderResult();
            encounterBuilderResult.setXpTable(xpTableBuilder.buildXpTable(encounterBuilderInfo));
            encounterBuilderResult.setEncounterMonsterList(encounterMonsterListGenerator.generateEncounterList(encounterBuilderInfo.convertTypeToEnum(),
                    min_max_xp_calculator.calculateMinXp(xpTableBuilder.buildXpTable(encounterBuilderInfo)),
                    min_max_xp_calculator.calculateMaxXp(xpTableBuilder.buildXpTable(encounterBuilderInfo))));



            return new ResponseEntity<EncounterBuilderResult>(encounterBuilderResult, HttpStatus.OK);

        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<ControllerError>(new ControllerError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}







