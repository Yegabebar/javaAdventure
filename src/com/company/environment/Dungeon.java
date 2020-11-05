package com.company.environment;

public class Dungeon {

    public Room[] room;

    public Dungeon(int nbRooms){
        //The dungeon instanciation triggers the instanciation of an empty array of rooms
        this.room = new Room[nbRooms];
        System.out.println("Let's enter the dungeon");
    }

}
