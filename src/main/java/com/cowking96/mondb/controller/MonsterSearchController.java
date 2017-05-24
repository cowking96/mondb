package com.cowking96.mondb.controller;

import com.cowking96.mondb.model.MonsterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MonsterSearchController {

    private static final Logger LOG = LoggerFactory.getLogger(MonsterSearchController.class);


    @RequestMapping(path = "/monsters", method=RequestMethod.GET)
    public String searchForMonsters(@RequestParam(required = false) String name,
                                    @RequestParam(required = false)MonsterType type) {
        return "name: " + name;

    }


}


