package com.company.miscellaneous;

public enum MonsterType {
    BARBARIAN("Barbarian"),
    SORCERER("Sorcerer");

    public String MName;

    private MonsterType(String mName){
        this.MName = mName;
    }
}
