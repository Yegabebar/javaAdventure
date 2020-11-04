package com.company;

import com.company.environment.Dungeon;
import com.company.environment.Room;
import com.company.liveEntities.MonsterType;
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
                //avec l'arme qui correspond à l'ennemi
                if(dungeon.rooms[i].monster.monsterType.mtName.equals("Barbarian")){
                    hero.setWeaponType(WeaponType.SWORD);
                }else{
                    hero.setWeaponType(WeaponType.WATER_FLASK);
                }
                System.out.println("Type "+hero.weaponType.wtName+" to fight back");
                //Récupération entrée utilisateur
                String playerAction = Main.getPlayerInput();
                //Vérifie si le type d'arme correspond bien au type de monstre
                Boolean hit = manageInput(playerAction, dungeon.rooms[i].monster.monsterType);
                int dmgPlayerAttack=0;
                if(hit){
                    //Si c'est le cas, on attaque
                    dmgPlayerAttack = hero.attack();
                }

                //Actualisation des hp du monstre, peut ne pas changer si le joueur a entré quelque chose d'incorrect
                dungeon.rooms[i].monster.setHp((dungeon.rooms[i].monster.getHp()-dmgPlayerAttack));
                System.out.println("The "+dungeon.rooms[i].monster.monsterType.mtName+" has lost "+dmgPlayerAttack+" hp");

                if(dungeon.rooms[i].monster.getHp()==0){
                    System.out.println("You've killed the "+dungeon.rooms[i].monster.monsterType.mtName);
                }else{
                    System.out.println("He has only "+dungeon.rooms[i].monster.getHp()+" hp remaining");
                }

                System.out.println("");
            }
            if(i==Stats.nbRooms){
                System.out.println("Congratulations you beat the game!");
                return;
            }

        }

    }

    private static Boolean manageInput(String playerAction, MonsterType monsterType){
        Boolean hit = false;
        if(playerAction.equals("Sword")&&monsterType.mtName.equals("Barbarian")){
            hit = true;
        }else if(playerAction.equals("Water_Flask")&&monsterType.mtName.equals("Wizard")){
            hit = true;
        }
        return hit;
    }


    public static void gameOver(){
        System.out.println("You died with a lot of suffering");
        return;
    }

}
