package com.cowking96.mondb.controller;

import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;
import com.cowking96.mondb.service.MonsterPredicateBuilder;
import com.cowking96.mondb.util.ControllerError;
import com.cowking96.mondb.util.MonsterSearchInfo;
import com.querydsl.core.BooleanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.cowking96.mondb.service.MonsterService;

@RestController
public class MonsterSearchController {

    private static final Logger LOG = LoggerFactory.getLogger(MonsterSearchController.class);

    @Autowired
    private MonsterService monsterService;

    @RequestMapping(value = "/monsters",method = RequestMethod.POST)
    public ResponseEntity<?> searchForMonsters(MonsterSearchInfo monsterSearchInfo) {

        try {

            LOG.debug("The post function has been called with search info: {}", monsterSearchInfo.toString());

            Iterable<Monster> monsters = monsterService.findByCriteria(monsterSearchInfo.getName(),
                    monsterSearchInfo.stringToMonsterType(),monsterSearchInfo.getCr(),
                    monsterSearchInfo.getCrComparison(),monsterSearchInfo.getXpValue(),monsterSearchInfo.getPageNumber());

            return new ResponseEntity<Iterable<Monster>>(monsters, HttpStatus.OK);

        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<ControllerError>(new ControllerError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

 @RequestMapping(path = "/monsters", method = RequestMethod.GET)
    public ResponseEntity<?> searchForMonsters (
         @RequestParam(required = false) String name,
        @RequestParam(required = false) MonsterType[] type,
        @RequestParam(required = false) Float cr,
        @RequestParam(required = false) String crComparison,
        @RequestParam(required = false) Integer xpValue,
        @RequestParam(required = false) String pageNumber){

        try {

            Iterable<Monster> monsters = monsterService.findByCriteria(name,type,cr,crComparison,xpValue,pageNumber);
            return new ResponseEntity<Iterable<Monster>>(monsters, HttpStatus.OK);

        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<ControllerError>(new ControllerError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        }



}







