package com.cowking96.mondb.service;

import com.cowking96.mondb.service.encounterBuilderService.XpTableBuilder;
import com.cowking96.mondb.service.encounterBuilderService.XpTableBuilderImpl;
import com.cowking96.mondb.util.EncounterBuilderInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;


public class XpTableBuilderTest {

    @Autowired
    EncounterBuilderInfo encounterBuilderInfo;





    @Test
    public void should_build_Xp_Table_Toughest_Single_Creature(){
        EncounterBuilderInfo encounterBuilderInfo = new EncounterBuilderInfo();

        encounterBuilderInfo.setPartySize(5);
        encounterBuilderInfo.setPartyLevel(5);

        XpTableBuilder xpTableBuilder = new XpTableBuilderImpl();
        int toughestSingleCreature = (xpTableBuilder.buildXpTable(encounterBuilderInfo))[0][3];
        assertThat(toughestSingleCreature).isEqualTo(5500);

    }

    @Test
    public void should_build_Xp_Table_Weakest_15_Creature(){
        EncounterBuilderInfo encounterBuilderInfo = new EncounterBuilderInfo();

        encounterBuilderInfo.setPartySize(5);
        encounterBuilderInfo.setPartyLevel(5);

        XpTableBuilder xpTableBuilder = new XpTableBuilderImpl();
        int toughestSingleCreature = (xpTableBuilder.buildXpTable(encounterBuilderInfo))[5][0];
        assertThat(toughestSingleCreature).isEqualTo(312);

    }

}
