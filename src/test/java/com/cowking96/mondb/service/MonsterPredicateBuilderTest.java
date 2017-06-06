package com.cowking96.mondb.service;

import com.cowking96.mondb.model.MonsterType;
import com.querydsl.core.types.Predicate;
import org.junit.Ignore;
import org.junit.Test;

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

        MonsterType[] types = {MonsterType.BEAST};
        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,types,null,null,null,null);
        assertThat(predicate.toString()).isEqualTo("monster.type = BEAST");
    }

    @Test
    public void should_build_predicate_for_given_cr() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,null,1.0f,null,null,null);
        assertThat(predicate.toString()).isEqualTo("monster.cr = 1.0");
    }

    @Test
    public void should_build_predicate_for_given_cr_and_ltCrComparison() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,null,1.0f,"<",null,null);
        assertThat(predicate.toString()).isEqualTo("monster.cr <= 1.0");
    }

    @Test
    public void should_build_predicate_for_given_cr_and_gtCrComparison() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,null,1.0f,">",null,null);
        assertThat(predicate.toString()).isEqualTo("monster.cr >= 1.0");
    }

    @Test
    public void should_build_predicate_for_given_cr_and_eqCrComparison() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,null,1.0f,"=",null,null);
        assertThat(predicate.toString()).isEqualTo("monster.cr = 1.0");
    }

    @Test
    public void should_build_predicate_for_given_cr_and_invalidCrComparison() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,null,1.0f,"?",null,null);
        assertThat(predicate.toString()).isEqualTo("monster.cr = 1.0");
    }

    @Test
    public void should_build_predicate_for_given_xpValue() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,null,null,null,100,null);
        assertThat(predicate.toString()).isEqualTo("monster.xpValue = 100");
    }

    @Test
    public void should_build_predicate_for_given_pageNumber() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null,null,null,null,null,"MM100");
        assertThat(predicate.toString()).isEqualTo("eqIc(monster.pageNumber,MM100)");
    }

    @Test
    public void should_build_predicate_for_given_cr_and_name() {

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate("Orc",null,1.0f,">",null,null);
        assertThat(predicate.toString()).isEqualTo("eqIc(monster.name,Orc) && monster.cr >= 1.0");
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

        MonsterType[] types = {MonsterType.BEAST,MonsterType.CELESTIAL};

        MonsterPredicateBuilder monsterPredicateBuilder = new MonsterPredicateBuilder();

        Predicate predicate = monsterPredicateBuilder.buildPredicate(null, types, null, null, null, null);
        assertThat(predicate.toString()).isEqualTo("monster.type = BEAST || monster.type = CELESTIAL");
    }
}
