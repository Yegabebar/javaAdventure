package com.company.liveEntities;

public class Monster {
    MonsterType monsterType;
    int hp;
    int atk;

    public Monster(MonsterType monsterType){
        //Récupérer les valeurs hp et atk depuis classe game
        this.hp = hp;
        this.atk = atk;
        this.monsterType = monsterType;
        attack(atk);

    }
    public int attack(int atk){
        //Ajouter une chance de critical hit selon le type de monstre
        int dmg = atk;
        System.out.println("The sorcerer is launching a strike of lightning at you");
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
