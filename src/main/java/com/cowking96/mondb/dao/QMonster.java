package com.cowking96.mondb.dao;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.cowking96.mondb.model.Monster;
import com.cowking96.mondb.model.MonsterType;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMonster is a Querydsl query type for Monster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMonster extends EntityPathBase<Monster> {

    private static final long serialVersionUID = 51931573L;

    public static final QMonster monster = new QMonster("monster");

    public final NumberPath<Float> cr = createNumber("cr", Float.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath pageNumber = createString("pageNumber");

    public final EnumPath<MonsterType> type = createEnum("type", MonsterType.class);

    public final NumberPath<Integer> xpValue = createNumber("xpValue", Integer.class);

    public QMonster(String variable) {
        super(Monster.class, forVariable(variable));
    }

    public QMonster(Path<? extends Monster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMonster(PathMetadata metadata) {
        super(Monster.class, metadata);
    }

}

