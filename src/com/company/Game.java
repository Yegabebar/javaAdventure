package com.company;

import com.company.environment.Dungeon;
import com.company.liveEntities.Player;

public class Game {

    public static void startGame(){
        int nbRooms=5;
        int atkPlayer=10;
        int hpPlayer=200;

        Player hero = new Player(hpPlayer, atkPlayer);
        Dungeon dungeon = new Dungeon(nbRooms);
        System.out.println("Welcome to Coding Dungeon");

        Main.getPlayerInput();








    }

    public static void gameOver(){

    }

}
