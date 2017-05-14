package com.cowking96.mondb.dao;

import com.cowking96.mondb.model.Monster;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class MonsterDaoImpl implements MonsterDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void persist(Monster monster) {
        em.persist(monster);
    }

    @Override
    public List<Monster> findAll() {
        return em.createQuery("SELECT * FROM Monster").getResultList();
    }


}
