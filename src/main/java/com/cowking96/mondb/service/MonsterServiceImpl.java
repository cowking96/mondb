package com.cowking96.mondb.service;


import com.cowking96.mondb.dao.MonsterDao;
import com.cowking96.mondb.model.Monster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonsterServiceImpl implements MonsterService {

    static final Logger LOG = LoggerFactory.getLogger(MonsterServiceImpl.class);

    @Autowired
    private MonsterDao monsterDao;

    public MonsterServiceImpl(){
        LOG.debug("MonsterServiceImpl constructed");
    }

    @Override
    public List<Monster> listAll() {
        return monsterDao.findAll();
    }
}
