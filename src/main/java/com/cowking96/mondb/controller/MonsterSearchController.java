package com.cowking96.mondb.controller;

import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;
import com.cowking96.mondb.util.ControllerError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(path = "/monsters", method = RequestMethod.GET)
    public ResponseEntity<?> searchForMonsters (@RequestParam(required = false) String name,
        @RequestParam(required = false) MonsterType type,
        @RequestParam(required = false) Float cr,
        @RequestParam(required = false) Integer xpValue,
        @RequestParam(required = false) String pageNumber){

        try {

            Iterable<Monster> monsters = monsterService.findByCriteria(name, type, cr, xpValue, pageNumber);
            return new ResponseEntity<Iterable<Monster>>(monsters, HttpStatus.OK);

        } catch(Exception e) {
            return new ResponseEntity<ControllerError>(new ControllerError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



