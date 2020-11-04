package com.company.liveEntities;

import com.company.miscellaneous.WeaponType;

public class Player {
    public WeaponType WType;
    int hp;
    int atk;

    public Player(int hpNewPlayer, int atkNewPlayer){
        hp = hpNewPlayer;
        atk = atkNewPlayer;
    }
    
    public int attack(String stringWeaponType, int flaskBonus){
        int dmg =10;
        switch (stringWeaponType) {
            case "Water_Flask" -> {
                dmg += flaskBonus;
            }
        }
        return dmg;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public WeaponType getWeaponType() {
        return WType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.WType = weaponType;
    }
}
