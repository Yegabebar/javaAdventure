package com.company.miscellaneous;

public enum WeaponType {
    SWORD("Sword"),
    WATER_FLASK("Water_Flask");

    public String wName;

    private WeaponType(String wtName){
        this.wName = wtName;
    }
}
