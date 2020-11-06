package com.company.environment;

import com.company.Game;
import com.company.Main;
import com.company.liveEntities.Player;
import com.company.miscellaneous.Events;
import com.company.miscellaneous.Stats;
import com.company.miscellaneous.WeaponType;

public class Dungeon {

    public Room[] room;

    public Dungeon(int nbRooms){
        //The dungeon instanciation triggers the instanciation of an empty array of rooms
        room = new Room[nbRooms];
        System.out.println("Let's enter the dungeon");
    }

    /**
     * The main game mechanic happens here.
     * We iterate on a for loop, each time a monster is beaton in its while loop.
     * @param hero
     */
    public void enterDungeon(Player hero){
        long startTime = System.nanoTime(); //Start the timer
        //Main loop, used create a room with a monster at each turn, we pass room to room each time we get out of the while.
        for(int i= 0; i<Stats.getNbRooms(); i++){
            int flaskBonus=0;
            //Shortened notation of the current room when we iterate on the for loop

            System.out.println("᭶᭶᭶᭶ ROOM "+(i+1)+" ᭶᭶᭶᭶");
            //Room generation inside the current dungeon slot, generates the monster as well
            room[i]=new Room();
            //Combats happen here, while the monster is not dead
            while(room[i].monster.getHp()>0){
                int dmgPlayerAttack=0;
                int dmgMonsterAttack=0;

                System.out.println("==== NEW TURN ===");
                //If the monster is not Ko, (managed by a boolean in another class)
                if(room[i].monster.isKoStatus()==false){
                    //Set the damage value for the monster attack
                    dmgMonsterAttack = room[i].monster.attack();
                    //Substract the player health with the monster damage, then display the result
                    hero.setHp(hero.getHp()-dmgMonsterAttack);
                    if(room[i].monster.isKoStatus()==false){System.out.println("You have lost "+dmgMonsterAttack+" hp");}

                }else{
                    //Else if the monster is Ko, we reset the monsterKo state for the next turn
                    room[i].monster.setKoStatus(false);
                    System.out.println("The Barbarian starts to recover");
                }

                //Check the monster type, in order to know which weapon the player will have to use
                if(room[i].monster.MonsterType.MonsterName.equals("Barbarian")){
                    hero.setWeaponType(WeaponType.SWORD);
                }else{
                    hero.setWeaponType(WeaponType.WATER_FLASK);
                    //If it's a sorcerer we try to get the player knocked out and store the result in a boolean for later use
                    hero.setKoStatus(Events.eventRandomizer(Stats.getSorcererEventRate()));
                }
                //GAME OVER is managed here. If the player's hp are down to 0, a message is displayed by the function and the player is redirected to the main menu.
                if(Game.gameOver(hero, room[i])){return;}

                System.out.println("You have only "+hero.getHp()+" hp remaining"); //If the player is not dead we display the remaining HP

                if(hero.isKoStatus()){ //Checks if the monster knocks down the player:if true, skip the rest of the turn
                    System.out.println("The monster knocked you down for one turn");
                    System.out.println("");
                    continue;
                }

                //If the player is not dead yet, the player is asked for input
                System.out.println("Type "+hero.WeaponType.WeaponName +" to fight back");
                String playerAction = Main.getPlayerInput();
                //Check if the input is a correct one+ if the weapon matches the monster type
                boolean hit = Game.manageInput(playerAction, room[i].monster.MonsterType);
                //If it's the case, the monster will be hit
                if(hit){
                    System.out.println("====== HIT ======");
                    //Set the damage value for the player attack, and then apply it on the monster's life
                    dmgPlayerAttack = hero.attack(hero.WeaponType.WeaponName, flaskBonus);
                    room[i].monster.setHp((room[i].monster.getHp()-dmgPlayerAttack));
                    //Displays how many HP the monster has lost, and then display the monster(s status accordingly
                    System.out.println("The "+room[i].monster.MonsterType.MonsterName +" has lost "+dmgPlayerAttack+" hp");
                    //This function has two goals: initialize the flask bonus and attempt to get the knockout effect for the barbarian
                    flaskBonus = hero.initPlayerEvents(hero, flaskBonus, room[i]);

                    if(room[i].monster.getHp()<=0){//If the monster is dead and the room is the last one, the player wins.
                        //If the room was the last, the player wins
                        if(i==Stats.getNbRooms()-1){
                            //The player is congratulated prompted to enter its nickname in this function
                            Game.gameCompleted(startTime);
                            return;
                        }//If it wasn't the last room, the message is not the same one
                        System.out.println("Congrats, the "+room[i].monster.MonsterType.MonsterName +" is dead, you can open the next door");
                        System.out.println("=================");
                    }else{//If the monster is not dead, we display the remaining monster's HP
                        System.out.println("He has only "+room[i].monster.getHp()+" hp remaining");
                    }
                }else{System.out.println("You miss!");} //Else if not hit, the attacked missed.
                System.out.println(""); //Visual separation
            }
            //We reset the variable monsterKo as we don't want to set Ko the monster from the next room
            room[i].monster.setKoStatus(false);
        }
    }
}
