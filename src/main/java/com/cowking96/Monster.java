package com.cowking96;

/**
 * Created by nate on 5/11/17.
 */
public class Monster {
    private String name;

    private int cr;

    private int xpValue;

    private int pageNumber;

    private enum type{
        Humanoid,
        Undead,
        Abberation,
        Fiend,
        Elemental,
        Celestial,
        Beast,
        Construct,
        Dragon,
        Giant,
        Monstrocity,
        Plant,
        Fey,
        Ooz,

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
