package com.company.environment;

import java.util.ArrayList;

public class Dungeon {
    ArrayList<Room> rooms;
    public int nbRooms;
    //A voir l'utilité de cette variable
    int nbCurrentRoom;

    public Dungeon(int nbRooms){
        //Voir si besoin d'itérer sur la liste pour
        this.rooms = new ArrayList<Room>(nbRooms);
        System.out.println("Let's enter the dungeon");

    }

    //Ajouter méthode openDoor
    public void openDoor(){

    }

}
