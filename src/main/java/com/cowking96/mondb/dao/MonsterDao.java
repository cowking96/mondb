package com.cowking96.mondb.dao;

import com.cowking96.mondb.model.Monster;
import java.util.List;

public interface MonsterDao {


    public void persist(Monster monster);

    public List<Monster> findAll();

}
