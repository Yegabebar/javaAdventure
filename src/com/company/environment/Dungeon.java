package com.company.environment;

public class Dungeon {

    public Room[] room;
    public int nbRooms;


    public Dungeon(int nbRooms){
        //L'instanciation du donjon déclenche la création du nombre de pièces du donjon
        this.room = new Room[nbRooms];
        System.out.println("Let's enter the dungeon");
    }

}
