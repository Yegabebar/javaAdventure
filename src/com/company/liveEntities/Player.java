package com.company.liveEntities;


import com.company.miscellaneous.WeaponType;

public class Player {
    public WeaponType WeaponType;
    int hp;
    int atk;

    public Player(int hpNewPlayer, int atkNewPlayer){
        hp = hpNewPlayer;
        atk = atkNewPlayer;
    }

    /**
     * When the weapon used is a flask: This method will supercharge the base damages with the current flask bonus.
     * The flask bonus varies according to how many times it has been stacked in previous turns.
     * When the weapon is a sword, it just attacks with the base damages.
     * @param stringWeaponType
     * @param flaskBonus
     * @return an int representing the amount of damages to hit the monsters with.
     */
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

    public void setWeaponType(WeaponType weaponType) {
        this.WeaponType = weaponType;
    }
}
