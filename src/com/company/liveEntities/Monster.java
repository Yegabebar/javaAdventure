package com.company.liveEntities;

import com.company.miscellaneous.Events;
import com.company.miscellaneous.MonsterType;
import com.company.miscellaneous.Stats;

public class Monster {
    public MonsterType MType;
    int hp;
    int atk;

    public Monster(MonsterType newMonsterType, int hpNewMonster, int atkNewMonster){
        //Récupérer les valeurs hp et atk depuis classe game
        MType = newMonsterType;
        hp = hpNewMonster;
        atk = atkNewMonster;

    }

    public int attack(){

        boolean incapacitating = false;
        String monsterAction;
        int dmg=Stats.atkMonster;
        if(MType.MName =="Barbarian"){
            //30% de chances dégats double
            if(Events.eventRandomizer(Stats.barbarianEventRate)==true){
                dmg*=Stats.barbarianAttackScoreMultiplier;
                System.out.println("Critical hit!");
            }
            monsterAction=" strikes you with an axe";
        }else{//A sortir de la méthode attack?
            //10% de chances de paralysie
            //incapacitating = Events.eventRandomizer(Stats.sorcererBuffRate);
            monsterAction=" is launching a strike of lightning at you";
        }

        System.out.println("The "+ MType.MName +monsterAction);
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
}
