package com.company.environment;

import java.util.ArrayList;

public class Dungeon {
    ArrayList<Room> rooms;
    public int nbRooms;

    public Dungeon(int nbRooms){
        this.rooms = new ArrayList<Room>(nbRooms);
        System.out.println("Let's enter the dungeon");

    }


}
