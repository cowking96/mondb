package com.cowking96.mondb.model;

import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

public class MonsterTest {

    @Test
    public void empty_construction(){
        Monster exampleMonster = new Monster();
        assertThat(exampleMonster.getName()).isNull();
        assertThat(exampleMonster.getCr()).isEqualTo((float)0.0);
        assertThat(exampleMonster.getXpValue()).isEqualTo(0);
        assertThat(exampleMonster.getPageNumber()).isNull();
        assertThat(exampleMonster.getId()).isNull();
        assertThat(exampleMonster.getType()).isEqualTo(MonsterType.NONE);
    }

}
