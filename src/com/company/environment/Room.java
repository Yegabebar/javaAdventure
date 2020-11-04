package com.company.environment;

import com.company.liveEntities.Monster;
import com.company.liveEntities.MonsterType;
import com.company.miscellaneous.Stats;


import java.util.concurrent.ThreadLocalRandom;

public class Room {
    public Monster monster;
    public MonsterType monsterType;

    public Room(){
        //L'instanciation de la room entraine la création d'un monstre, comme si on ouvrait la porte
        generateRandomMonster();
    }

    private void generateRandomMonster(){
        //On génère un chiffre random à 0 ou 1 pour définir un type de monstre
        int randomMonsterTypeToGenerate = ThreadLocalRandom.current().nextInt(0, 2);
        //Puis on définit quel est le type de monstre à instancier
        if(randomMonsterTypeToGenerate ==0){
            this.monsterType = MonsterType.BARBARIAN;
        }else{
            this.monsterType = MonsterType.WIZARD;
        }
        System.out.println("Behind the door is a "+monsterType.mtName);
        //Instanciation du monstre dans la room
        this.monster = new Monster(this.monsterType, Stats.hpMonster, Stats.atkMonster);
    }

}
