package com.cowking96.mondb.service.encounterBuilderService;

import com.cowking96.mondb.util.EncounterBuilderInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class XpTableBuilderImpl implements XpTableBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(EncounterBuilder.class);

    private static int baseXpThreshhold[][] = {
            {25,50,75,100},{50,100,150,200},{75,150,225,400},{125,250,375,500},
            {250,500,750,1100}, {300,600,900,1400},{350,750,1100,1700},
            {450,900,1400,2100},{550,1100,1600,2400},{600,1200,1900,2800},
            {800,1600,2400,3600},{1000,2000,3000,4500},{1100,2200,3400,5100},
            {1250,2500,3800,5700},{1400,2800,4300,6400},
            {1600,3200,4800,7200},{2000,3900,5900,8800},{2100,4200,6300,9500},
            {2400,4900,7300,10900},{2800,5700,8500,12700}
    };

    private static float sizeModifiers[][] = {
            {.5f, 1, 1.5f, 2, 2.5f ,3},
            {1, 1.5f, 2, 2.5f ,3, 4},
            {1.5f, 2, 2.5f ,3, 4, 5}
    };


    public int[][] buildXpTable(EncounterBuilderInfo encounterBuilderInfo) {

        int partyLevel = encounterBuilderInfo.getPartyLevel();
        int partySize = encounterBuilderInfo.getPartySize();

        int[] xpThreshhold = baseXpThreshhold[partyLevel-1];
        int[] partyXpThreshhold = new int[4];
        int index = 0;

        for(int i : xpThreshhold ) {
            partyXpThreshhold[index] = i * partySize;
            index++;
        }

        int partySizeIndex = encounterBuilderInfo.convertPartySizeToindex(encounterBuilderInfo.getPartySize());
        float[] sizeModifier = sizeModifiers[partySizeIndex];

        int[][] effectiveXpThreshhold = new int[6][4];

        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 4; j++) {
                effectiveXpThreshhold[i][j] = (int) (partyXpThreshhold[j] / sizeModifier[i]);
            }
        }
        return effectiveXpThreshhold;
    }
}
