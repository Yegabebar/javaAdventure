package com.company;

import com.company.environment.Dungeon;
import com.company.environment.Room;
import com.company.liveEntities.Player;
import com.company.miscellaneous.Stats;
import com.company.miscellaneous.WeaponType;


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
            while(dungeon.rooms[i].monster.getHp()>0){
                //Le monstre attaque le joueur
                int dmgMonsterAttack = dungeon.rooms[i].monster.attack();
                hero.setHp(hero.getHp()-dmgMonsterAttack);
                System.out.println("You have lost "+dmgMonsterAttack+" hp");
                System.out.println("You have only "+hero.getHp()+" hp remaining");

                if(hero.getHp()<0){
                    gameOver();
                }
                //Si le joueur n'est pas mort, on demande une entrée à l'utilisateur
                if(dungeon.rooms[i].monster.monsterType.mtName.equals("Barbarian")){
                    hero.setWeaponType(WeaponType.SWORD);
                }else{
                    hero.setWeaponType(WeaponType.WATER_FLASK);
                }

                System.out.println("Type "+hero.getWeaponType()+" to fight back");
                String playerAction = Main.getPlayerInput();
                //Fonction vérification d'entrée? Intégré dans Player.attack pour le moment

                int dmgPlayerAttack = hero.attack(playerAction, dungeon.rooms[i].monster);
                dungeon.rooms[i].monster.setHp((dungeon.rooms[i].monster.getHp()-dmgPlayerAttack));

                System.out.println("HP Monster at end of turn"+dungeon.rooms[i].monster.getHp());


            }
            if(i==Stats.nbRooms){
                System.out.println("Congratulations you beat the game!");
                return;
            }

        }



    }

    public static void gameOver(){
        System.out.println("You died with a lot of suffering");
    }

}
