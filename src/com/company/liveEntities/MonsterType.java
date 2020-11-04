package com.company.liveEntities;

public enum MonsterType {
    BARBARIAN("Barbarian"),
    SORCERER("Sorcerer");

    public String mtName;

    private MonsterType(String mName){
        this.mtName = mName;
    }
}
