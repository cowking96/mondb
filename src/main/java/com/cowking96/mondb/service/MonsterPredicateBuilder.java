package com.cowking96.mondb.service;

import com.cowking96.mondb.model.MonsterType;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cowking96.mondb.dao.QMonster.monster;

@Service
public class MonsterPredicateBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(MonsterPredicateBuilder.class);

    public Predicate buildPredicate(String name, List<MonsterType> types, Float minCr, Float maxCr, Integer minXpValue, Integer maxXpValue){

        BooleanBuilder builder = new BooleanBuilder();

        if(name != null) {
            if(name.trim().length() > 0) {
                builder = nameParameter(builder, name);
            }
        }

        if(minCr != null){
            builder = builder.and(monster.cr.goe(minCr));
        }

        if(maxCr != null){
            builder = builder.and(monster.cr.loe(maxCr));
        }

        if(minXpValue != null){
            builder = builder.and(monster.xpValue.goe(minXpValue));
        }

        if(maxXpValue != null){
            builder = builder.and(monster.xpValue.loe(maxXpValue));
        }

        if(types != null){
            if(types.size() == 1) {
                builder = builder.and((monster.type.eq(types.get(0))));
            } else {

                BooleanBuilder orBuilder = new BooleanBuilder();
                for(MonsterType t : types) {
                    orBuilder = orBuilder.or(monster.type.eq(t));
                }

                builder = builder.andAnyOf(orBuilder.getValue());

            }
        }

        return builder.getValue();
    }

    private BooleanBuilder nameParameter(BooleanBuilder builder,String name){
        int length = name.length();

        if(name.startsWith("*") && name.endsWith("*")) {
            return builder.and((monster.name.containsIgnoreCase(name.substring(1, length-1))));
        }

        if(name.startsWith("*")) {
            return builder = builder.and((monster.name.endsWithIgnoreCase(name.substring(1,length))));
        }

        if(name.endsWith("*")) {
            return builder = builder.and((monster.name.startsWithIgnoreCase((name.substring(0,length-1)))));
        }

        else {
            return builder = builder.and(monster.name.equalsIgnoreCase(name));
        }
    }

}

