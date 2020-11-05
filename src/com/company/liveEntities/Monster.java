package com.company.liveEntities;

import com.company.miscellaneous.Events;
import com.company.miscellaneous.MonsterType;
import com.company.miscellaneous.Stats;

public class Monster {
    public MonsterType MType;
    int hp;
    int atk;

    public Monster(MonsterType newMonsterType, int hpNewMonster, int atkNewMonster){
        //Sets the values for the properties of the Monster object
        MType = newMonsterType;
        hp = hpNewMonster;
        atk = atkNewMonster;

    }

    public int attack(){
        String monsterAction;
        int dmg=Stats.atkMonster;
        //If the monster is a barbarian
        if(MType.MName =="Barbarian"){
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
        System.out.println("The "+ MType.MName +monsterAction);
        return dmg;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

}
