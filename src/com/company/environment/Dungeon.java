package com.company.environment;

import java.util.ArrayList;

public class Dungeon {

    public Room[] rooms;
    public int nbRooms;


    public Dungeon(int nbRooms){
        //L'instanciation du donjon déclenche la création du nombre de pièces du donjon
        this.rooms = new Room[nbRooms];
        System.out.println("Let's enter the dungeon");
    }

}
