package com.company.miscellaneous;

public enum WeaponType {
    SWORD("Sword"),
    WATER_FLASK("Water_Flask");

    public String WeaponName;

    private WeaponType(String wtName){
        this.WeaponName = wtName;
    }
}
