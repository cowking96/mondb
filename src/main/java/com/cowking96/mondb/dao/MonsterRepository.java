package com.cowking96.mondb.dao;

import com.cowking96.mondb.model.Monster;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MonsterRepository extends CrudRepository<Monster, Long> {


}
