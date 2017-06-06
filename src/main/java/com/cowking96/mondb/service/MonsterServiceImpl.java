package com.cowking96.mondb.service;

import com.cowking96.mondb.dao.MonsterRepository;
import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;
import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonsterServiceImpl implements MonsterService {

    private static final Logger LOG = LoggerFactory.getLogger(MonsterServiceImpl.class);

    private MonsterRepository monsterRepository;
    private MonsterPredicateBuilder predicateBuilder;

    @Autowired
    public MonsterServiceImpl(MonsterRepository monsterRepository, MonsterPredicateBuilder predicateBuilder ) {
        this.monsterRepository = monsterRepository;
        this.predicateBuilder = predicateBuilder;
    }

    public Iterable<Monster> findByCriteria(String name, MonsterType type[], Float cr, String crComparison, Integer xpValue, String pageNumber) {

        Predicate predicate = predicateBuilder.buildPredicate(name, type, cr, crComparison, xpValue, pageNumber);

        if(predicate == null){
            LOG.debug("Our Predicate is: null. Searching for all monsters");
        }
        else {
            LOG.debug("Our Predicate is: {}", predicate.toString());
        }

        return monsterRepository.findAll(predicate);
    }
}





