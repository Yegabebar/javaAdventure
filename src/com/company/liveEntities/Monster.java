package com.company.liveEntities;

import com.company.miscellaneous.Events;
import com.company.miscellaneous.MonsterType;
import com.company.miscellaneous.Stats;

public class Monster {
    public MonsterType MonsterType;
    int hp;
    int atk;

    public Monster(MonsterType newMonsterType, int hpNewMonster, int atkNewMonster){
        //Sets the values for the properties of the Monster object
        MonsterType = newMonsterType;
        hp = hpNewMonster;
        atk = atkNewMonster;

    }

    /**
     * When the monster type is a Barbarian, we will try to trigger the monster event which double its base damages.
     * It's done by using the function eventRandomizer() that returns a boolean.
     * If true, the damage bonus is applied in this method and then returned to the start() function as an int.
     * @return an int representing the amount of damage to apply on the player's health.
     */
    public int attack(){
        String monsterAction;
        int dmg=Stats.atkMonster;
        //If the monster is a barbarian
        if(MonsterType.MonsterName =="Barbarian"){
            //Tries to trigger the event when the player will be knocked out
            if(Events.eventRandomizer(Stats.barbarianEventRate)){
                dmg*=Stats.barbarianAttackScoreMultiplier;
                System.out.println("Critical hit!");
            }
            monsterAction=" strikes you with an axe";
        }else{
            monsterAction=" is launching a strike of lightning at you";
        }
        //Displays the attack message depending on the monster type which is attacking
        System.out.println("The "+ MonsterType.MonsterName +monsterAction);
        return dmg;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

}
