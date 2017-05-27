package com.cowking96.mondb.dao;

import com.cowking96.mondb.model.Monster;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface MonsterRepository extends CrudRepository<Monster, Long>, QueryDslPredicateExecutor<Monster> {


}
