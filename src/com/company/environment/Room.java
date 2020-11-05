package com.company.environment;

import com.company.liveEntities.Monster;
import com.company.miscellaneous.MonsterType;
import com.company.miscellaneous.Stats;


import java.util.concurrent.ThreadLocalRandom;

public class Room {
    public Monster monster;
    public MonsterType monsterType;

    public Room(){
        //The room instanciation triggers the instanciation of a monster, as if we actually opened a door
        generateRandomMonster();
    }

    private void generateRandomMonster(){
        //Generates a random int to define which kind of monster will spawn
        int randomMonsterTypeToGenerate = ThreadLocalRandom.current().nextInt(0, 2);
        if(randomMonsterTypeToGenerate ==0){
            this.monsterType = MonsterType.BARBARIAN;
        }else{
            this.monsterType = MonsterType.SORCERER;
        }
        System.out.println("Behind the door is a "+monsterType.MName);
        //Instanciate a monster with the randomly chosen monster type
        this.monster = new Monster(this.monsterType, Stats.hpMonster, Stats.atkMonster);
    }

}
