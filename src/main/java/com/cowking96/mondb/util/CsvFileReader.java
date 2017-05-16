package com.cowking96.mondb.util;


import com.cowking96.mondb.dao.MonsterRepository;
import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


@Component
public class CsvFileReader {

    static final Logger LOG = LoggerFactory.getLogger(CsvFileReader.class);

    private static MonsterRepository monsterRepository;

    @Autowired
    public void setRepository(MonsterRepository repo) {
        CsvFileReader.monsterRepository = repo;
    }

    public static void loadData() {

        LOG.info("Begining to load monster data from MonsterCSV.csv...");

        String inputFileName = "MonsterCsv.csv";

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFileName));
            String line = br.readLine();
            int count = 1;

            while (line != null)
            {
                LOG.debug("Reading csv line {}: {}", count, line);

                String[] currentLine = line.split("\\|");

                String currentName = currentLine[0];
                MonsterType currentType = convertToMonsterType(currentLine[1]);
                float currentCr = convertToFloat(currentLine[2]);
                int currentXp = convertToInteger(currentLine[3]);
                String currentPage = "MM" + currentLine[4];

                Monster monster = new Monster(currentName,currentCr,currentXp,currentPage,currentType);

                monsterRepository.save(monster);

                line = br.readLine();
                count += 1;

            }

        }
        catch(FileNotFoundException fnfe) {
            LOG.error("Cannot find file {}. It should be in the same folder as the jar!", inputFileName);
            throw new RuntimeException("Monster file not found");
        }
        catch(IOException io) {
            LOG.error("There was an error reading the file {}", inputFileName);
            throw new RuntimeException("File read error", io);
        }
        catch(Exception e){
            LOG.error("Something went wrong when reading the input file {}", inputFileName);
            throw new RuntimeException("Unknown file read or processing error", e);
        }

        LOG.info("Finished monster data load from MonsterCSV.csv");

        Iterable<Monster> monsters = monsterRepository.findAll();
        if(monsters.iterator().hasNext()) {
            Monster m = monsters.iterator().next();
            LOG.debug("Monster details: {}", m.toString());
        }
        else {
            throw new RuntimeException("Cannot find any monsters in repository!");
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




