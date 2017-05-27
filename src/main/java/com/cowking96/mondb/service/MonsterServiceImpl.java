package com.cowking96.mondb.service;


import com.cowking96.mondb.dao.MonsterRepository;
import com.cowking96.mondb.dao.QMonster;
import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonsterServiceImpl implements MonsterService {

    private MonsterRepository monsterRepository;

    @Autowired
    public MonsterServiceImpl(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    @Override
    public Iterable<Monster> findByCriteria(String name, MonsterType type, Float cr, Integer xpValue, String pageNumber) {

        QMonster monster = QMonster.monster;

        BooleanExpression expression = null;

        if(name != null) {
            if(name.trim().length() > 0) {
                expression = monster.name.equalsIgnoreCase(name);
            }
        }


        return monsterRepository.findAll(expression);
    }
}
