package com.company.liveEntities;

public enum MonsterType {
    BARBARIAN("Barbarian"),
    WIZARD("Wizard");

    public String mtName;

    private MonsterType(String mName){
        this.mtName =mName;
    }
}
