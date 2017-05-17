package com.cowking96.mondb.service;


import com.cowking96.mondb.dao.MonsterRepository;
import com.cowking96.mondb.model.Monster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonsterServiceImpl implements MonsterService {

    private static final Logger LOG = LoggerFactory.getLogger(MonsterServiceImpl.class);

    @Autowired
    private MonsterRepository monsterRepository;

    public MonsterServiceImpl(){
        LOG.debug("MonsterServiceImpl constructed");
    }

    @Override
    public Iterable<Monster> listAll() {
        return monsterRepository.findAll();
    }
}
