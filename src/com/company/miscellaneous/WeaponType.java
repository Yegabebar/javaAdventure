package com.company.miscellaneous;

public enum WeaponType {
    SWORD("Sword"),
    WATER_FLASK("Water_Flask");

    public String wtName;

    private WeaponType(String wtName){
        this.wtName = wtName;
    }
}
