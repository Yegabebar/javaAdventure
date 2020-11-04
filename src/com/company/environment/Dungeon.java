package com.company.environment;

import java.util.ArrayList;

public class Dungeon {
    //ArrayList<Room> rooms;
    public Room[] rooms;
    public int nbRooms;
    //A voir l'utilité de cette variable
    int nbCurrentRoom;

    public Dungeon(int nbRooms){
        //L'instanciation du donjon déclenche la création du nombre de pièces du donjon
        this.rooms = new Room[nbRooms];
        System.out.println("Let's enter the dungeon");
    }

    //Ajouter méthode openDoor
    public void openDoor(){

    }

}
