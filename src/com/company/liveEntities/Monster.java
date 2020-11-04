package com.company.liveEntities;

public class Monster {
    MonsterType monsterType;
    int hp;
    int atk;

    public Monster(MonsterType monsterType, int hp, int atk){
        //Récupérer les valeurs hp et atk depuis classe game
        this.hp = hp;
        this.atk = atk;
        this.monsterType = monsterType;
    }

    public int attack(){

        double criticalHitProcPercentage;
        String monsterAction;
        if(monsterType.mName=="Barbarian"){
            //30% de chances dégats double
            monsterAction=" strikes you with an axe";
            //criticalHitProcPercentage = 0.3;
        }else{
            //10% de chances de paralysie
            monsterAction=" is launching a strike of lightning at you";
            //criticalHitProcPercentage = 0.1;
        }
        /*double criticalHitRand = Math.random();
        boolean criticalHit=false;
        if (criticalHitRand < criticalHitProcPercentage){
            criticalHit=true;
        }*/
        int dmg = atk;
        System.out.println("The "+monsterType.mName+monsterAction);
        return dmg;
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(MonsterType monsterType) {
        this.monsterType = monsterType;
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
