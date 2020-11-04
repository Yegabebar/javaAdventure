package com.company;

import com.company.environment.Dungeon;
import com.company.environment.Room;
import com.company.liveEntities.Player;
import com.company.liveEntities.Stats;


public class Game {

    public static void startGame(){
        //On instancie le Player character et le donjon
        Player hero = new Player(Stats.hpPlayer, Stats.atkPlayer);
        Dungeon dungeon = new Dungeon(Stats.nbRooms);

        System.out.println("Welcome to Coding Dungeon");
        //Routine principale
        for(int i= 0; i<Stats.nbRooms; i++){

            System.out.println("Room number: "+i);
            //Création d'une room dans la première pièce du donjon
            dungeon.rooms[i]=new Room();
            System.out.println("Room number"+(i+1)+dungeon.rooms[i]);
            //Tant que le monstre a des hp
            System.out.println("HP Monster before first turn: "+dungeon.rooms[i].monster.getHp());
            System.out.println("HP Player before first turn: "+hero.getHp());

            while(dungeon.rooms[i].monster.getHp()>0){
                dungeon.rooms[i].monster.attack()
                //et si le joueur n'est pas mort
                if(hero.getHp()<0){
                    gameOver();
                }

                //on demande une entrée à l'utilisateur
                System.out.println("");
                String playerAction = Main.getPlayerInput();
                int dmgAttack;
                dmgAttack = hero.attack(playerAction, dungeon.rooms[i].monster);
                dungeon.rooms[i].monster.setHp((dungeon.rooms[i].monster.getHp()-dmgAttack));

                System.out.println("HP Monster at end of turn"+dungeon.rooms[i].monster.getHp());


            }


        }














    }

    public static void gameOver(){
        System.out.println("You died with a lot of suffering");
    }

}
