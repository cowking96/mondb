package com.cowking96.mondb.service;

import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;

import java.util.List;

public interface MonsterService {

    public Iterable<Monster> findByCriteria(String name, MonsterType type, Float cr, Integer xpValue, String pageNumber);
}
