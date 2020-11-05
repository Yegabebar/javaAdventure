package com.company.miscellaneous;

public enum WeaponType {
    SWORD("Sword"),
    WATER_FLASK("Water_Flask");

    public String WName;

    private WeaponType(String wtName){
        this.WName = wtName;
    }
}
