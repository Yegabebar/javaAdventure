package com.company;

import com.company.environment.Dungeon;
import com.company.environment.Room;
import com.company.liveEntities.Player;

public class Game {

    public static void startGame(){
        int nbRooms=5;
        int atkPlayer=10;
        int hpPlayer=200;

        //On instancie le Player character et le donjon
        Player hero = new Player(hpPlayer, atkPlayer);
        Dungeon dungeon = new Dungeon(nbRooms);

        System.out.println("Welcome to Coding Dungeon");
        //Routine principale: création de rooms
        for(int i= 1; i<nbRooms; i++){
            System.out.println("Room number: "+i);
            //Création d'une room dans la première pièce du donjon
            dungeon.rooms[i]=new Room();
            System.out.println("Room number"+i+dungeon.rooms[i]);
            String action = Main.getPlayerInput();
        }














    }

    public static void gameOver(){

    }

}
