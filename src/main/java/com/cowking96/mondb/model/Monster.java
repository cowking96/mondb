package com.cowking96.mondb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Monster {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private float cr;
    private int xpValue;
    private String pageNumber;
    private MonsterType type;

    public Monster(){
        type = MonsterType.NONE;
    }

    public Monster(String name, float cr, int xpValue, String pageNumber, MonsterType type){
        this.name = name;
        this.cr = cr;
        this.xpValue = xpValue;
        this.pageNumber = pageNumber;
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("name: " + name + " ");
        buf.append("cr: " + cr + " ");
        buf.append("xpValue: " + xpValue + " ");
        buf. append("pageNumber: " + pageNumber + " ");
        buf.append("type: " + type);

        return buf.toString();
    }


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}

    public float getCr() {
        return cr;
    }
    public void setCr(float cr) {
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
