package com.company;

import com.company.environment.Dungeon;

public class Game {

    public static void start(){
        int nbRooms=5;
        int atkPlayer=10;

        System.out.println("Welcome to Coding Dungeon");
        Dungeon dungeon = new Dungeon(nbRooms);

        //Modifier méthode pour qu'elle accepte plus de choses que int
        Main.getPlayerInput();








    }
}
