package com.cowking96.mondb.service.encounterBuilderService;

import com.cowking96.mondb.dao.MonsterRepository;
import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;
import com.cowking96.mondb.service.MonsterPredicateBuilder;
import com.cowking96.mondb.util.DatabaseCreator;
import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class EncounterMonsterListGeneratorImpl implements  EncounterMonsterListGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(EncounterMonsterListGeneratorImpl.class);
    private MonsterRepository monsterRepository;
    private MonsterPredicateBuilder predicateBuilder;

    @Autowired
    public EncounterMonsterListGeneratorImpl(MonsterRepository monsterRepository, MonsterPredicateBuilder predicateBuilder ) {
        this.monsterRepository = monsterRepository;
        this.predicateBuilder = predicateBuilder;
    }

    public Iterable<Monster>  generateEncounterList(List<MonsterType> types, int minXp, int maxXp){

        Predicate predicate = predicateBuilder.buildPredicate(null, types, null, null, minXp, maxXp);

        if(predicate == null){
            LOG.debug("Our Predicate is: null. Searching for all monsters");
        }
        else {
            LOG.debug("Our Predicate is: {}", predicate.toString());
        }

        return monsterRepository.findAll(predicate);
    }
}
