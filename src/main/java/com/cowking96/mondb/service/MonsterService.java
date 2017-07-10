package com.cowking96.mondb.service;

import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;
import com.cowking96.mondb.util.MonsterSearchInfo;

import java.util.List;

public interface MonsterService {

    public Iterable<Monster> findMonsters(MonsterSearchInfo monsterSearchInfo);
}
