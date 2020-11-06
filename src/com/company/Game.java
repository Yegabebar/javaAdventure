package com.company;

import com.company.environment.Dungeon;
import com.company.environment.Room;
import com.company.miscellaneous.*;
import com.company.liveEntities.Player;

import java.io.IOException;

public class Game {
    /**
     * The main game mechanic happens here.
     * We iterate on a for loop, each time a monster is beaton in its while loop.
     * @param mode
     */
    public static void start(String mode){
        System.out.println("=Welcome to Coding Dungeon=");
        Stats.setMode(mode);
        System.out.println("");
        //We instanciate the Player character and the dungeon
        Player hero = new Player(Stats.getHpPlayer(), Stats.getAtkPlayer());
        //The dungeon creates a list of rooms without any object rooms in it.
        Dungeon dungeon = new Dungeon(Stats.getNbRooms());
        long startTime = System.nanoTime(); //Start the timer
        //Main loop, used create a room with a monster at each turn, we pass room to room each time we get out of the while.
        for(int i= 0; i<dungeon.room.length; i++){
            int flaskBonus=0;
            //Shortened notation of the current room when we iterate on the for loop
            Room room = dungeon.room[i];
            System.out.println("᭶᭶᭶᭶ ROOM "+(i+1)+" ᭶᭶᭶᭶");
            //Room generation inside the current dungeon slot, generates the monster as well
            room=new Room();
            //Combats happen here, while the monster is not dead
            while(room.monster.getHp()>0){
                int dmgPlayerAttack=0;
                int dmgMonsterAttack=0;

                System.out.println("==== NEW TURN ===");
                //If the monster is not Ko, (managed by a boolean in another class)
                if(room.monster.isMonsterKo==false){
                    //Set the damage value for the monster attack
                    dmgMonsterAttack = room.monster.attack();
                    //Substract the player health with the monster damage, then display the result
                    hero.setHp(hero.getHp()-dmgMonsterAttack);
                    if(room.monster.isMonsterKo==false){System.out.println("You have lost "+dmgMonsterAttack+" hp");}

                }else{
                    //Else if the monster is Ko, we reset the monsterKo state for the next turn
                    room.monster.isMonsterKo=false;
                    System.out.println("The Barbarian starts to recover");
                }

                //Check the monster type, in order to know which weapon the player will have to use
                if(room.monster.MonsterType.MonsterName.equals("Barbarian")){
                    hero.setWeaponType(WeaponType.SWORD);
                }else{
                    hero.setWeaponType(WeaponType.WATER_FLASK);
                    //If it's a sorcerer we try to get the player knocked out and store the result in a boolean for later use
                    hero.isPlayerKo = Events.eventRandomizer(Stats.getSorcererEventRate());
                }
                //GAME OVER is managed here. If the player's hp are down to 0, a message is displayed by the function and the player is redirected to the main menu.
                if(gameOver(hero, room)){return;}

                System.out.println("You have only "+hero.getHp()+" hp remaining"); //If the player is not dead we display the remaining HP

                if(hero.isPlayerKo){ //Checks if the monster knocks down the player:if true, skip the rest of the turn
                    System.out.println("The monster knocked you down for one turn");
                    System.out.println("");
                    continue;
                }

                //If the player is not dead yet, the player is asked for input
                System.out.println("Type "+hero.WeaponType.WeaponName +" to fight back");
                String playerAction = Main.getPlayerInput();
                //Check if the input is a correct one+ if the weapon matches the monster type
                boolean hit = manageInput(playerAction, room.monster.MonsterType);
                //If it's the case, the monster will be hit
                if(hit){
                    System.out.println("====== HIT ======");
                    //Set the damage value for the player attack, and then apply it on the monster's life
                    dmgPlayerAttack = hero.attack(hero.WeaponType.WeaponName, flaskBonus);
                    room.monster.setHp((room.monster.getHp()-dmgPlayerAttack));
                    //Displays how many HP the monster has lost, and then display the monster(s status accordingly
                    System.out.println("The "+room.monster.MonsterType.MonsterName +" has lost "+dmgPlayerAttack+" hp");
                    //This function has two goals: initialize the flask bonus and attempt to get the knockout effect for the barbarian
                    flaskBonus = initPlayerEvents(hero, flaskBonus, room);

                    if(room.monster.getHp()<=0){//If the monster is dead and the room is the last one, the player wins.
                        //If the room was the last, the player wins
                        if(i==Stats.getNbRooms()-1){
                            //The player is congratulated prompted to enter its nickname in this function
                            gameCompleted(startTime);
                            return;
                        }//If it wasn't the last room, the message is not the same one
                        System.out.println("Congrats, the "+room.monster.MonsterType.MonsterName +" is dead, you can open the next door");
                        System.out.println("=================");
                    }else{//If the monster is not dead, we display the remaining monster's HP
                        System.out.println("He has only "+room.monster.getHp()+" hp remaining");
                    }
                }else{System.out.println("You miss!");} //Else if not hit, the attacked missed.
                System.out.println(""); //Visual separation
            }
            //We reset the variable monsterKo as we don't want to set Ko the monster from the next room
            room.monster.isMonsterKo=false;
        }
    }

    /**
     * This function calculates the time elapsed for the game completion, asks for the player's nickname
     * and stores the results in the scoreboard.
     * @param startTime
     */
    private static void gameCompleted(long startTime) {
        long timeElapsed = System.nanoTime()- startTime;
        timeElapsed/=Math.pow(10,9);
        System.out.println("Game duration: "+timeElapsed+" seconds");
        System.out.println("Please enter your nickname");
        String nickname = Main.getPlayerInput();
        Scores.setScore(timeElapsed, nickname);
        System.out.println("Congratulations, the treasure is yours!");
        System.out.println("");
    }

    /**
     * This function does not actually quit the current game as "return;" wouldn't work there.
     * That's why it returns a boolean instead, used straight away in start() to get back to the main menu.
     * @param hero
     * @param room
     * @return a boolean that says if the player is dead or not.
     */
    private static boolean gameOver(Player hero, Room room) {
        boolean dead=false;
        if(hero.getHp()<1){ //If the player health is down to zero the player looses and gets brought back to the main menu
            dead=true;
            System.out.println("");
            System.out.println("=== GAME OVER ===");
            System.out.println("");
            if(Stats.getMode().equals("normal")){
                System.out.println("Sorry, you have been killed by a "+ room.monsterType.MonsterName);
            }else{
                System.out.println("Congratulations, you are very much dead!");
            }

        }
        return dead;
    }

    /**
     * This function sets the flask buff stack when the weapon used is a FLask.
     * If the weapon is a sword, it will set up the knockout event for knocking out barbarians
     * The knockout event is stored in the class Events for later use.
     * @param hero
     * @param flaskBonus
     * @param room
     * @return an int representing the amount of the stackable flask bonus
     */
    private static int initPlayerEvents(Player hero, int flaskBonus, Room room) {
        //If the weapon is the flask, we initiliaze the flask bonus
        if(hero.WeaponType.WeaponName.equals("Water_Flask")){
            //Displays text depending if whether the bonus has already been initialized or not
            if(flaskBonus==0){
                System.out.println("Flask Bonus has been reseted");
            }else{
                System.out.println("Another flask hits the sorcerer adding water to the pool at his feet,"
                        +" your damage is now "+ (hero.getAtk()+flaskBonus));
            }
            //Then we add +2 to the bonus score for the next turn (next while loop)
            flaskBonus +=2;
        }else{ //else if the weapon is the sword, we try to knock out the monster
            //If the player event kicks in (monster knocked out)
            if(Events.eventRandomizer(Stats.getPlayerEventRate())){
                room.monster.isMonsterKo=true; //We set the variable monsterKo to true for the next turn
                System.out.println("The Barbarian is knocked out for one turn after you hit it on its head");
            }
        }
        return flaskBonus;
    }

    /**
     * This function checks if the player input is correct according to the monster type.
     * If not, this function will
     * @param playerAction
     * @param monsterType
     * @return a boolean indicating if the attack misses or if we actually attack the monster afterwards.
     */
    private static boolean manageInput(String playerAction, MonsterType monsterType){
        boolean hit = false;
        //If the player input matches the type of the monster, the boolean "hit" is set to true
        if(playerAction.equals("Sword")&&monsterType.MonsterName.equals("Barbarian")){
            hit = true;
        }else if(playerAction.equals("Water_Flask")&&monsterType.MonsterName.equals("Sorcerer")){
            hit = true;
        }
        return hit;
    }
}


