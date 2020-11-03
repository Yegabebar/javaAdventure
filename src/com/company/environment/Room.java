package com.company.environment;

import com.company.liveEntities.Monster;
import com.company.liveEntities.MonsterType;

import java.util.Random;

public class Room {
    Monster monster;
    MonsterType monsterType;
    Random intMonsterType;


    Room(){
        intMonsterType = new Random();
        Monster monster;
        //On génère un chiffre random à 0 ou 1 pour définir un type de monstre
        int randomMonsterTypeToGenerate = intMonsterType.nextInt(1);
        if(randomMonsterTypeToGenerate ==0){
            MonsterType monsterType = MonsterType.BARBARIAN;
        }else{
            MonsterType monsterType = MonsterType.WIZARD;
        }
        this.monster = new Monster(monsterType);
        //A déplacer potentiellement
        System.out.println("Behind the door is a "+monsterType.mName);


    }

}
