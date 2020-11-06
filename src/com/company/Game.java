package com.company;

import com.company.environment.Dungeon;
import com.company.environment.Room;
import com.company.miscellaneous.*;
import com.company.liveEntities.Player;

public class Game {
    /**
     * Starts the game, the rest of the mechanics are stored in the Dungeon.enterDungeon() method
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
        dungeon.enterDungeon(hero);
        return;

    }

    /**
     * This function calculates the time elapsed for the game completion, asks for the player's nickname
     * and stores the results in the scoreboard.
     * @param startTime
     */
    public static void gameCompleted(long startTime) {
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
    public static boolean gameOver(Player hero, Room room) {
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
     * This function checks if the player input is correct according to the monster type.
     * If not, this function will
     * @param playerAction
     * @param monsterType
     * @return a boolean indicating if the attack misses or if we actually attack the monster afterwards.
     */
    public static boolean manageInput(String playerAction, MonsterType monsterType){
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


