package com.company.liveEntities;

import com.company.miscellaneous.WeaponType;

public class Player {
    public WeaponType weaponType;
    int hp;
    int atk;

    public Player(int hp, int atk){
        this.hp = hp;
        this.atk = atk;
    }
    
    public int attack(String playerAction, Monster monster){
        int dmg =0;
        if(playerAction.equals("Sword")&&monster.monsterType.mtName.equals("Barbarian")){
            dmg = atk;
        }else if(playerAction.equals("Water_Flask")&&monster.monsterType.mtName.equals("Wizard")){
            dmg = atk;
        }
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
