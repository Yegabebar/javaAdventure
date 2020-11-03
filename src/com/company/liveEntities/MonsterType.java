package com.company.liveEntities;

public enum MonsterType {
    BARBARIAN("Barbarian"),
    WIZARD("Wizard");

    public String mName;

    private MonsterType(String monsterTypeName){
        this.mName =monsterTypeName;
    }
}
