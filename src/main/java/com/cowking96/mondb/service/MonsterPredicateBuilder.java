package com.cowking96.mondb.service;

import com.cowking96.mondb.dao.MonsterRepository;
import com.cowking96.mondb.dao.QMonster;
import com.cowking96.mondb.model.MonsterType;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import static com.cowking96.mondb.dao.QMonster.monster;

@Service
public class MonsterPredicateBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(MonsterPredicateBuilder.class);

    public Predicate buildPredicate(String name, MonsterType type, Float cr, String crComparison, Integer xpValue, String pageNumber){

        if(crComparison == null){
            crComparison = "=";
        }

        BooleanBuilder builder = new BooleanBuilder();

        if(name != null) {
            if(name.trim().length() > 0) {
                builder = nameParameter(builder, name);
            }
        }

        if(cr != null){
            builder = crParameter(builder, cr, crComparison);
        }

        if(xpValue != null){
            builder = builder.and(monster.xpValue.eq(xpValue));
        }

        if(pageNumber != null) {
            builder = builder.and(monster.pageNumber.equalsIgnoreCase(pageNumber));
        }

        if(type != null){
            builder = builder.and(monster.type.eq(type));
        }

        return builder.getValue();
    }

    private BooleanBuilder crParameter(BooleanBuilder builder,Float cr,String crComparison){

        if(crComparison.equals(">")){
            return builder = builder.and(monster.cr.goe(cr));
        }

        if (crComparison .equals("<")){
            return builder = builder.and(monster.cr.loe(cr));
        }

        if(crComparison.equals("=")){
            return builder = builder.and(monster.cr.eq(cr));
        }
        else {
            LOG.warn("Ignoring invalid cr comparison string: {}", crComparison);
            return builder = builder.and(monster.cr.eq(cr));
        }
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

