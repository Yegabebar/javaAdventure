package com.company.miscellaneous;

public enum MonsterType {
    BARBARIAN("Barbarian"),
    SORCERER("Sorcerer");

    public String MonsterName;

    private MonsterType(String mName){
        this.MonsterName = mName;
    }
}
