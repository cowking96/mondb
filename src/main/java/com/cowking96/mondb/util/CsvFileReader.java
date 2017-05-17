package com.cowking96.mondb.util;


import com.cowking96.mondb.dao.MonsterRepository;
import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class CsvFileReader {

    private static final Logger LOG = LoggerFactory.getLogger(CsvFileReader.class);

    private static final String INPUT_FILE_NAME = "MonsterCsv.csv";

    private static MonsterRepository monsterRepository;

    @Autowired
    public void setRepository(MonsterRepository repo) {
        CsvFileReader.monsterRepository = repo;
    }

    public static void loadData() {
        MonsterFileReaderImpl.LineReader().forEach(s ->{
            String[] currentLine = s.split("\\|");

            String currentName = currentLine[0];
            MonsterType currentType = convertToMonsterType(currentLine[1]);
            float currentCr = convertToFloat(currentLine[2]);
            int currentXp = convertToInteger(currentLine[3]);
            String currentPage = "MM" + currentLine[4];

            Monster monster = new Monster(currentName,currentCr,currentXp,currentPage,currentType);

            monsterRepository.save(monster);
        });


        Iterable<Monster> monsters = monsterRepository.findAll();
        if(monsters.iterator().hasNext()) {
            Monster m = monsters.iterator().next();
            LOG.debug("Monster details: {}", m.toString());
        }
        }







    private static int convertToInteger(String value) {
        return Integer.parseInt(value);
    }

    private static float convertToFloat(String value) {
        return Float.parseFloat(value);
    }

    private static MonsterType convertToMonsterType(String type) {
        return MonsterType.valueOf(type.toUpperCase());

    }

}




