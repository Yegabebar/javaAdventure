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

    /**
     * This method will only ever be called by this class.
     * It randomly chooses between 0 and 1, then uses this result to generate a certain type of monster.
     * The base stats HP and ATK are gathered from the Stats class which is some kind of config file to tweak as we want.
     */
    private void generateRandomMonster(){
        //Generates a random int to define which kind of monster will spawn
        int randomMonsterTypeToGenerate = ThreadLocalRandom.current().nextInt(0, 2);
        if(randomMonsterTypeToGenerate ==0){
            monsterType = MonsterType.BARBARIAN;
        }else{
            monsterType = MonsterType.SORCERER;
        }
        System.out.println("Behind the door is a "+monsterType.MonsterName);
        //Instanciate a monster with the randomly chosen monster type
        monster = new Monster(monsterType, Stats.hpMonster, Stats.atkMonster);
    }

}
