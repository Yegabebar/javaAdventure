package com.company.liveEntities;


import com.company.environment.Room;
import com.company.miscellaneous.Events;
import com.company.miscellaneous.Stats;
import com.company.miscellaneous.WeaponType;

public class Player {
    public WeaponType WeaponType;
    public static boolean isPlayerKo;
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
    /**
     * This function sets the flask buff stack when the weapon used is a FLask.
     * If the weapon is a sword, it will set up the knockout event for knocking out barbarians
     * The knockout event is stored in the class Events for later use.
     * @param hero
     * @param flaskBonus
     * @param room
     * @return an int representing the amount of the stackable flask bonus
     */
    public static int initPlayerEvents(Player hero, int flaskBonus, Room room) {
        //If the weapon is the flask, we initiliaze the flask bonus
        if(hero.WeaponType.WeaponName.equals("Water_Flask")){
            //Displays text depending if whether the bonus has already been initialized or not
            if(flaskBonus==0){
                System.out.println("Flask Bonus has been reseted");
            }else{
                System.out.println("Another flask hits the sorcerer adding water to the pool at his feet,"
                        +" your damage is now "+ (hero.getAtk()+flaskBonus));
            }
            //Then we add +2 to the bonus score for the next turn (next while loop)
            flaskBonus +=2;
        }else{ //else if the weapon is the sword, we try to knock out the monster
            //If the player event kicks in (monster knocked out)
            if(Events.eventRandomizer(Stats.getPlayerEventRate())){
                room.monster.isMonsterKo=true; //We set the variable monsterKo to true for the next turn
                System.out.println("The Barbarian is knocked out for one turn after you hit it on its head");
            }
        }
        return flaskBonus;
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
