package com.cowking96.mondb.service;

import com.cowking96.mondb.service.encounterBuilderService.Min_Max_Xp_Calculator;
import com.cowking96.mondb.service.encounterBuilderService.Min_Max_Xp_CalculatorImpl;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class Min_Max_Xp_ClaculatorTest {

    @Test
    public void should_find_min_xp(){
        int[][] xpTable =  new int[5][4];
        xpTable[4][0] = 15;

        Min_Max_Xp_Calculator xp_calculator = new Min_Max_Xp_CalculatorImpl();
        assertThat(xp_calculator.calculateMinXp(xpTable)).isEqualTo(1);

    }

    @Test
    public void should_find_max_xp(){
        int[][] xpTable =  new int[5][4];
        xpTable[0][3] = 100;

        Min_Max_Xp_Calculator xp_calculator = new Min_Max_Xp_CalculatorImpl();
        assertThat(xp_calculator.calculateMaxXp(xpTable)).isEqualTo(100);

    }

}
