package com.company;

import com.company.environment.Dungeon;
import com.company.environment.Room;
import com.company.miscellaneous.MonsterType;
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
            int flaskBonus=0;
            System.out.println("⍑⍑⍑⍑ ROOM "+(i+1)+" ⍑⍑⍑⍑");
            //Création d'une room dans la première pièce du donjon
            dungeon.room[i]=new Room();
            //Tant que le monstre a des hp
            while(dungeon.room[i].monster.getHp()>0){

                int dmgPlayerAttack=0;

                System.out.println("==== NEW TURN ===");
                //Le monstre attaque le joueur
                int dmgMonsterAttack = dungeon.room[i].monster.attack();
                hero.setHp(hero.getHp()-dmgMonsterAttack);
                if(hero.getHp()<1){
                    System.out.println("");
                    System.out.println("=== GAME OVER ===");
                    System.out.println("You died with a lot of suffering");
                    return;
                }
                System.out.println("You have lost "+dmgMonsterAttack+" hp");
                System.out.println("You have only "+hero.getHp()+" hp remaining");

                //Si le joueur n'est pas mort, on demande une entrée à l'utilisateur
                //avec l'arme qui correspond à l'ennemi
                if(dungeon.room[i].monster.MType.MName.equals("Barbarian")){
                    hero.setWeaponType(WeaponType.SWORD);
                }else{
                    hero.setWeaponType(WeaponType.WATER_FLASK);
                }
                System.out.println("Type "+hero.WType.wName +" to fight back");
                //Récupération entrée utilisateur
                String playerAction = Main.getPlayerInput();
                //Vérifie si le type d'arme correspond bien au type de monstre
                Boolean hit = manageInput(playerAction, dungeon.room[i].monster.MType);

                if(hit==true){
                    System.out.println("====== HIT ======");
                    //Si c'est le cas, on attaque le monstre en deux temps = détermination du score d'attaque
                    dmgPlayerAttack = hero.attack(hero.WType.wName, flaskBonus);
                    //Puis actualisation des hp du monstre
                    dungeon.room[i].monster.setHp((dungeon.room[i].monster.getHp()-dmgPlayerAttack));
                    //Si on a attaqué avec une flasque
                    flaskBonus = addFlaskBonus(hero, flaskBonus);

                    System.out.println("The "+dungeon.room[i].monster.MType.MName +" has lost "+dmgPlayerAttack+" hp");
                    if(dungeon.room[i].monster.getHp()==0){
                        System.out.println("Congrats, the "+dungeon.room[i].monster.MType.MName +" is dead, you can open the next door");
                        System.out.println("=================");
                    }else{
                        System.out.println("He has only "+dungeon.room[i].monster.getHp()+" hp remaining");
                    }
                }
                System.out.println(""); //Marque la fin du tour visuellement
            }
            if(i==Stats.nbRooms){
                System.out.println("Congratulations you beat the game!");
                return;
            }
        }
    }

    private static int addFlaskBonus(Player hero, int flaskBonus) {
        if(hero.WType.wName.equals("Water_Flask")){
            //On affiche une phrase suivant la valeur du bonus
            if(flaskBonus ==0){
                System.out.println("Flask Bonus has been reseted");
            }else{
                System.out.println("Another flask hits the sorcerer adding water to the pool at his feet,"
                        +" your damage is now "+ (hero.getAtk()+flaskBonus));
            }
            //Puis on incrémente le bonus de 2 pour le prochain tour (passage boucle while monster pas mort)
            flaskBonus +=2;
        }
        return flaskBonus;
    }

    private static Boolean manageInput(String playerAction, MonsterType monsterType){
        Boolean hit = false;

        if(playerAction.equals("Sword")&&monsterType.MName.equals("Barbarian")){
            hit = true;
        }else if(playerAction.equals("Water_Flask")&&monsterType.MName.equals("Sorcerer")){
            hit = true;
        }
        return hit;
    }


    public static void gameOver(){


    }

}
