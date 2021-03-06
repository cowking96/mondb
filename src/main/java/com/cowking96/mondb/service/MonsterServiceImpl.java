package com.cowking96.mondb.service;

import com.cowking96.mondb.dao.MonsterRepository;
import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;
import com.cowking96.mondb.util.MonsterSearchInfo;
import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MonsterServiceImpl implements MonsterService {

    private static final Logger LOG = LoggerFactory.getLogger(MonsterServiceImpl.class);

    private MonsterRepository monsterRepository;
    private MonsterPredicateBuilder predicateBuilder;

    @Autowired
    public MonsterServiceImpl(MonsterRepository monsterRepository, MonsterPredicateBuilder predicateBuilder ) {
        this.monsterRepository = monsterRepository;
        this.predicateBuilder = predicateBuilder;
    }

    @Override
    public Iterable<Monster> findMonsters(MonsterSearchInfo monsterSearchInfo) {
        return find(monsterSearchInfo.getName(),
                monsterSearchInfo.convertTypeToEnum(),
                monsterSearchInfo.getMinCr(),
                monsterSearchInfo.getMaxCr());
    }

    private Iterable<Monster> find(String name, List<MonsterType> type, Float minCr,Float maxCr) {
        

        Predicate predicate = predicateBuilder.buildPredicate(name, type, minCr, maxCr, null, null);

        if(predicate == null){
            LOG.debug("Our Predicate is: null. Searching for all monsters");
        }
        else {
            LOG.debug("Our Predicate is: {}", predicate.toString());
        }

        return monsterRepository.findAll(predicate);
    }

}





