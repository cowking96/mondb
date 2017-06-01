package com.cowking96.mondb.service;

import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;

public interface MonsterService {

    public Iterable<Monster> findByCriteria(String name, MonsterType type, Float cr, String crComparison, Integer xpValue, String pageNumber);
}
