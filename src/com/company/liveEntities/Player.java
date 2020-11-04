package com.company.liveEntities;

import com.company.miscellaneous.WeaponType;

public class Player {
    public WeaponType weaponType;
    int hp;
    int atk;

    public Player(int hpNewPlayer, int atkNewPlayer){
        hp = hpNewPlayer;
        atk = atkNewPlayer;
    }
    
    public int attack(){
        int dmg =10;
        return dmg;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }
}
