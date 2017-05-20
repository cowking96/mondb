package com.cowking96.mondb.util;

import com.cowking96.mondb.dao.MonsterRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DatabaseCreatorTest {

    @Test
    public void should_not_throw(){

        MonsterRepository mockMonsterRepository = mock(MonsterRepository.class);
        MonsterFileReader mockMonsterFileReader = mock(MonsterFileReader.class);

        List<String> l = new ArrayList<>();
        l.add("human|humanoid|1|1|1");
        when(mockMonsterFileReader.lineReader()).thenReturn(l);

        DatabaseCreator dbc = new DatabaseCreator(mockMonsterRepository, mockMonsterFileReader);
        dbc.loadData();
    }

    @Test
    public void should_throw_for_blank_name(){

        MonsterRepository mockMonsterRepository = mock(MonsterRepository.class);
        MonsterFileReader mockMonsterFileReader = mock(MonsterFileReader.class);

        List<String> l = new ArrayList<>();
        l.add("     |humanoid|1|1|1");
        when(mockMonsterFileReader.lineReader()).thenReturn(l);

        DatabaseCreator dbc = new DatabaseCreator(mockMonsterRepository, mockMonsterFileReader);

        try {

            dbc.loadData();
            fail("test should throw!");

        } catch(RuntimeException rte) {

            assertThat(rte.getMessage()).isEqualTo("Monster data cannot be blank");
        }
    }

    @Test
    public void should_throw_for_blank_cr(){

        MonsterRepository mockMonsterRepository = mock(MonsterRepository.class);
        MonsterFileReader mockMonsterFileReader = mock(MonsterFileReader.class);

        List<String> l = new ArrayList<>();
        l.add("human|humanoid|  |1|1");
        when(mockMonsterFileReader.lineReader()).thenReturn(l);

        DatabaseCreator dbc = new DatabaseCreator(mockMonsterRepository, mockMonsterFileReader);

        try {

            dbc.loadData();
            fail("test should throw!");

        } catch(RuntimeException rte) {

            assertThat(rte.getMessage()).isEqualTo("Monster data cannot be blank");
        }
    }

    @Test
    public void should_throw_for_blank_xp(){

        MonsterRepository mockMonsterRepository = mock(MonsterRepository.class);
        MonsterFileReader mockMonsterFileReader = mock(MonsterFileReader.class);

        List<String> l = new ArrayList<>();
        l.add("human|humanoid|1|   |1");
        when(mockMonsterFileReader.lineReader()).thenReturn(l);

        DatabaseCreator dbc = new DatabaseCreator(mockMonsterRepository, mockMonsterFileReader);

        try {

            dbc.loadData();
            fail("test should throw!");

        } catch(RuntimeException rte) {

            assertThat(rte.getMessage()).isEqualTo("Monster data cannot be blank");
        }


    }
    @Test
    public void should_throw_for_blank_pageNumber(){

        MonsterRepository mockMonsterRepository = mock(MonsterRepository.class);
        MonsterFileReader mockMonsterFileReader = mock(MonsterFileReader.class);

        List<String> l = new ArrayList<>();
        l.add("human|humanoid|1|1|    ");
        when(mockMonsterFileReader.lineReader()).thenReturn(l);

        DatabaseCreator dbc = new DatabaseCreator(mockMonsterRepository, mockMonsterFileReader);

        try {

            dbc.loadData();
            fail("test should throw!");

        } catch(RuntimeException rte) {

            assertThat(rte.getMessage()).isEqualTo("Monster data cannot be blank");
        }
    }

    @Test
    public void should_throw_for_negative_Cr() {

        MonsterRepository mockMonsterRepository = mock(MonsterRepository.class);
        MonsterFileReader mockMonsterFileReader = mock(MonsterFileReader.class);

        List<String> l = new ArrayList<>();
        l.add("human|humanoid|-1|1|1");
        when(mockMonsterFileReader.lineReader()).thenReturn(l);

        DatabaseCreator dbc = new DatabaseCreator(mockMonsterRepository, mockMonsterFileReader);

        try {

            dbc.loadData();
            fail("test should throw!");

        } catch (RuntimeException rte) {

            assertThat(rte.getMessage()).isEqualTo("Could not convert to Float, must be a nonegative number!");
        }

    }

    @Test
    public void should_throw_for_negative_Xp() {

        MonsterRepository mockMonsterRepository = mock(MonsterRepository.class);
        MonsterFileReader mockMonsterFileReader = mock(MonsterFileReader.class);

        List<String> l = new ArrayList<>();
        l.add("human|humanoid|1|-1|1");
        when(mockMonsterFileReader.lineReader()).thenReturn(l);

        DatabaseCreator dbc = new DatabaseCreator(mockMonsterRepository, mockMonsterFileReader);

        try {

            dbc.loadData();
            fail("test should throw!");

        } catch (RuntimeException rte) {

            assertThat(rte.getMessage()).isEqualTo("Could not convert to Integer, must be a whole number that is nonegative!");
        }

    }

    @Test
    public void should_throw_for_Invalid_MonsterType() {

        MonsterRepository mockMonsterRepository = mock(MonsterRepository.class);
        MonsterFileReader mockMonsterFileReader = mock(MonsterFileReader.class);

        List<String> l = new ArrayList<>();
        l.add("human|goober|1|1|1");
        when(mockMonsterFileReader.lineReader()).thenReturn(l);

        DatabaseCreator dbc = new DatabaseCreator(mockMonsterRepository, mockMonsterFileReader);

        try {

            dbc.loadData();
            fail("test should throw!");

        } catch (RuntimeException rte) {

            assertThat(rte.getMessage()).isEqualTo("Invalid monster type!");
        }

    }

    @Test
    public void should_throw_for_Number_as_MonsterType() {

        MonsterRepository mockMonsterRepository = mock(MonsterRepository.class);
        MonsterFileReader mockMonsterFileReader = mock(MonsterFileReader.class);

        List<String> l = new ArrayList<>();
        l.add("human|1|1|1|1");
        when(mockMonsterFileReader.lineReader()).thenReturn(l);

        DatabaseCreator dbc = new DatabaseCreator(mockMonsterRepository, mockMonsterFileReader);

        try {

            dbc.loadData();
            fail("test should throw!");

        } catch (RuntimeException rte) {

            assertThat(rte.getMessage()).isEqualTo("Invalid monster type!");
        }

    }

    @Test
    public void should_throw_for_cannot_convert_to_float() {

        MonsterRepository mockMonsterRepository = mock(MonsterRepository.class);
        MonsterFileReader mockMonsterFileReader = mock(MonsterFileReader.class);

        List<String> l = new ArrayList<>();
        l.add("human|humanoid|goober|1|1");
        when(mockMonsterFileReader.lineReader()).thenReturn(l);

        DatabaseCreator dbc = new DatabaseCreator(mockMonsterRepository, mockMonsterFileReader);

        try {

            dbc.loadData();
            fail("test should throw!");

        } catch (RuntimeException rte) {

            assertThat(rte.getMessage()).isEqualTo("Could not convert to Float, must be a nonegative number!");
        }

    }

    @Test
    public void should_throw_for_nonNumber_Xp() {

        MonsterRepository mockMonsterRepository = mock(MonsterRepository.class);
        MonsterFileReader mockMonsterFileReader = mock(MonsterFileReader.class);

        List<String> l = new ArrayList<>();
        l.add("human|humanoid|1|goober|1");
        when(mockMonsterFileReader.lineReader()).thenReturn(l);

        DatabaseCreator dbc = new DatabaseCreator(mockMonsterRepository, mockMonsterFileReader);

        try {

            dbc.loadData();
            fail("test should throw!");

        } catch (RuntimeException rte) {

            assertThat(rte.getMessage()).isEqualTo("Could not convert to Integer, must be a whole number that is nonegative!");
        }

    }

    @Test
    public void should_throw_for_nonNumber_Cr() {

        MonsterRepository mockMonsterRepository = mock(MonsterRepository.class);
        MonsterFileReader mockMonsterFileReader = mock(MonsterFileReader.class);

        List<String> l = new ArrayList<>();
        l.add("human|humanoid|goober|1|1");
        when(mockMonsterFileReader.lineReader()).thenReturn(l);

        DatabaseCreator dbc = new DatabaseCreator(mockMonsterRepository, mockMonsterFileReader);

        try {

            dbc.loadData();
            fail("test should throw!");

        } catch (RuntimeException rte) {

            assertThat(rte.getMessage()).isEqualTo("Could not convert to Float, must be a nonegative number!");
        }

    }

    @Test
    public void should_throw_for_fractional_Xp() {

        MonsterRepository mockMonsterRepository = mock(MonsterRepository.class);
        MonsterFileReader mockMonsterFileReader = mock(MonsterFileReader.class);

        List<String> l = new ArrayList<>();
        l.add("human|humanoid|1|0.5|1");
        when(mockMonsterFileReader.lineReader()).thenReturn(l);

        DatabaseCreator dbc = new DatabaseCreator(mockMonsterRepository, mockMonsterFileReader);

        try {

            dbc.loadData();
            fail("test should throw!");

        } catch (RuntimeException rte) {

            assertThat(rte.getMessage()).isEqualTo("Could not convert to Integer, must be a whole number that is nonegative!");
        }

    }

}
