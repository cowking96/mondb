package com.cowking96.mondb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Monster {

    @Id
    private Integer id;

    private String name;
    private int cr;
    private int xpValue;
    private String pageNumber;
    private MonsterType type;

    public Monster(){
        type = MonsterType.None;
    }


    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}

    public int getCr() {
        return cr;
    }
    public void setCr(int cr) {
        this.cr = cr;
    }

    public int getXpValue() {
        return xpValue;
    }
    public void setXpValue(int xpValue) {
        this.xpValue = xpValue;
    }

    public String getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public MonsterType getType() {
        return type;
    }
    public void setType(MonsterType type) {
        this.type = type;
    }
}
