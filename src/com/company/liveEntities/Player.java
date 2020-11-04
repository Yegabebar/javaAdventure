package com.company.liveEntities;

public class Player {
    int hp;
    int atk;

    public Player(int hp, int atk){
        this.hp = hp;
        this.atk = atk;
    }
    
    public int attack(String playerAction, Monster monster){
        int dmg =0;
        if(playerAction.equals("Sword")&&monster.monsterType.mName.equals("Barbarian")){
            dmg = atk;
        }else if(playerAction.equals("Water_Flask")&&monster.monsterType.mName.equals("Wizard")){
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



}
