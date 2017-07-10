package com.cowking96.mondb.service.encounterBuilderService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class Min_Max_Xp_CalculatorImpl implements  Min_Max_Xp_Calculator {

    public int calculateMinXp(int[][] xpTable) {
        int minXp = (int) (xpTable[4][0] / 15); //weakest possible group of 15 monsters
        return minXp;
    }

    public int calculateMaxXp(int[][] xpTable) {
        int maxXp = xpTable[0][3]; // deadliest single monster
        return maxXp;
    }
}
