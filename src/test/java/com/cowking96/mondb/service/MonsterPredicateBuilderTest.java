package com.cowking96.mondb.service;

import com.cowking96.mondb.model.MonsterType;
import com.querydsl.core.types.Predicate;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class MonsterPredicateBuilderTest {

    @Test
    public void should_build_predicate_for_given_name() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate("Orc",null,null,null,null,null);
        assertThat(predicate.toString()).isEqualTo("eqIc(monster.name,Orc)");
    }

    @Test
    public void should_build_null_predicate_for_empty_name() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate("  ",null,null,null,null,null);
        assertThat(predicate).isNull();
    }

    @Test
    public void should_build_predicate_for_given_type() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        List<MonsterType> types = new ArrayList<>();
        types.add(MonsterType.BEAST);
        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,types,null,null,null,null);
        assertThat(predicate.toString()).isEqualTo("monster.type = BEAST");
    }

    @Test
    public void should_build_predicate_for_given_minCr() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,null,1.0f,null,null,null);
        assertThat(predicate.toString()).isEqualTo("monster.cr >= 1.0");
    }

    @Test
    public void should_build_predicate_for_given_maxCr() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,null,null,10.0f,null,null);
        assertThat(predicate.toString()).isEqualTo("monster.cr <= 10.0");
    }

    @Test
    public void should_build_predicate_for_given_minCr_and_maxCr() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,null,1.0f,10.0f,null,null);
        assertThat(predicate.toString()).isEqualTo("monster.cr >= 1.0 && monster.cr <= 10.0");
    }


    @Test
    public void should_build_predicate_for_given_min_XpValue() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,null,null,null,100,null);
        assertThat(predicate.toString()).isEqualTo("monster.xpValue >= 100");
    }

    @Test
    public void should_build_predicate_for_given_max_XpValue() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,null,null,null,null,100);
        assertThat(predicate.toString()).isEqualTo("monster.xpValue <= 100");
    }

    @Test
    public void should_build_predicate_for_given_min_and_max_XpValue() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,null,null,null,10,100);
        assertThat(predicate.toString()).isEqualTo("monster.xpValue >= 10 && monster.xpValue <= 100");
    }

    @Test
    public void should_build_predicate_for_name_starts_with() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate("Orc*",null,null,null,null,null);
        assertThat(predicate.toString()).isEqualTo("startsWithIgnoreCase(monster.name,Orc)");
    }

    @Test
    public void should_build_predicate_for_name_ends_with() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate("*Orc",null,null,null,null,null);
        assertThat(predicate.toString()).isEqualTo("endsWithIgnoreCase(monster.name,Orc)");
    }

    @Test
    public void should_build_predicate_for_name_contains() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate("*Orc*",null,null,null,null,null);
        assertThat(predicate.toString()).isEqualTo("containsIc(monster.name,Orc)");
    }

    @Test
    public void should_build_null_predicate() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,null,null,null,null,null);
        assertThat(predicate).isNull();
    }

    @Test
    public void should_build_multitype_predicate() {

        List<MonsterType> types = new ArrayList<>();
        types.add(MonsterType.BEAST);
        types.add(MonsterType.CELESTIAL);

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null, types, null, null, null, null);
        assertThat(predicate.toString()).isEqualTo("monster.type = BEAST || monster.type = CELESTIAL");
    }
}
