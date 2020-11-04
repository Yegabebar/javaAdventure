package com.company.environment;

import com.company.liveEntities.Monster;
import com.company.liveEntities.MonsterType;


import java.util.concurrent.ThreadLocalRandom;

public class Room {
    public Monster monster;
    public MonsterType monsterType;

    public Room(){
        //On génère un chiffre random à 0 ou 1 pour définir un type de monstre
        int randomMonsterTypeToGenerate = ThreadLocalRandom.current().nextInt(0, 2);
        if(randomMonsterTypeToGenerate ==0){
            this.monsterType = MonsterType.BARBARIAN;
        }else{
            this.monsterType = MonsterType.WIZARD;
        }
        this.monster = new Monster(this.monsterType);
        System.out.println("Behind the door is a "+monsterType.mName);
        //L'instanciation de la room entraine la création d'un monstre, comme si on ouvrait la porte

    }

}
