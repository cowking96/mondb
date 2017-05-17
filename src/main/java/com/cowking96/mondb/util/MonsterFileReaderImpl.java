package com.cowking96.mondb.util;

import com.cowking96.mondb.dao.MonsterRepository;
import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MonsterFileReaderImpl implements MonsterFileReader {

    private static final String INPUT_FILE_NAME = "MonsterCsv.csv";
    private static final Logger LOG = LoggerFactory.getLogger(MonsterFileReaderImpl.class);

    public static List<String> LineReader() {

        try {
            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
            String line = br.readLine();
            List<String> listOfLines = new ArrayList<String>();

            while (line != null) {
                listOfLines.add(line);
                line = br.readLine();
            }
            return listOfLines;

        } catch (FileNotFoundException fnfe) {
            LOG.error("Cannot find file {}. It should be in the same folder as the jar!", INPUT_FILE_NAME);
            throw new RuntimeException("Monster file not found");
        } catch (IOException io) {
            LOG.error("There was an error reading the file {}", INPUT_FILE_NAME);
            throw new RuntimeException("File read error", io);
        } catch (Exception e) {
            LOG.error("Something went wrong when reading the input file {}", INPUT_FILE_NAME);
            throw new RuntimeException("Unknown file read or processing error", e);
        }


    }
}
