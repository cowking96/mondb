package com.cowking96.mondb.util;


import com.cowking96.mondb.dao.MonsterRepository;
import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseCreator {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseCreator.class);

    private static final String INPUT_FILE_NAME = "MonsterCsv.csv";
    private static final int EXPECTED_ARRAY_LENGTH = 5;

    private MonsterRepository monsterRepository;
    private MonsterFileReader monsterFileReader;

    @Autowired
    public DatabaseCreator(MonsterRepository monsterRepository, MonsterFileReader monsterFileReader) {

        this.monsterRepository = monsterRepository;
        this.monsterFileReader = monsterFileReader;
    }

    public void loadData() {

        monsterFileReader.lineReader().forEach(s -> {

            String[] currentLine = s.split("\\|");
            String[] cleanedLine = cleanLine(currentLine);

            String currentName = cleanedLine[0];
            MonsterType currentType = convertToMonsterType(cleanedLine[1]);
            float currentCr = convertToFloat(cleanedLine[2]);
            int currentXp = convertToInteger(cleanedLine[3]);
            String currentPage = "MM" + cleanedLine[4];

            Monster monster = new Monster(currentName,currentCr,currentXp,currentPage,currentType);

            monsterRepository.save(monster);
        });

    }

    private int convertToInteger(String value) {
        try {

            Integer n = Integer.parseInt(value);
            if (n < 0)
                throw new RuntimeException("Could not convert to Integer, must be whole !");

            return n;
        }catch (RuntimeException rte){
            throw new RuntimeException("Could not convert to Integer, must be a whole number that is nonegative!");
        }
    }

    private float convertToFloat(String value) {
        try {
            Float n = Float.parseFloat(value);
            if (n < 0)
                throw new RuntimeException("Could not convert to Float, must be a nonegative number!");

            return n;
        }catch (RuntimeException rte){
            throw new RuntimeException("Could not convert to Float, must be a nonegative number!");
        }
    }

    private MonsterType convertToMonsterType(String type) {
        try {

            return MonsterType.valueOf(type.toUpperCase());
        }catch (RuntimeException rte){
            throw new RuntimeException("Invalid monster type!");

        }
    }

    private String[] cleanLine(String[] dirtyLine){

        String[] cleanedLine = new String[EXPECTED_ARRAY_LENGTH];

        if(dirtyLine.length != EXPECTED_ARRAY_LENGTH) {
            throw new RuntimeException("A line has the wrong number of parameters");
        }

        int i = 0;
        for(String s : dirtyLine) {
            cleanedLine[i] = s.trim();
            if (cleanedLine[i].length() == 0) {
                throw new RuntimeException("Monster data cannot be blank");
            }

            i++;
        }

        return cleanedLine;
    }

}




