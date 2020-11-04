package com.company;

import com.company.environment.Dungeon;
import com.company.environment.Room;
import com.company.miscellaneous.Events;
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
                boolean playerIncapacitated = false;
                int dmgPlayerAttack=0;

                System.out.println("==== NEW TURN ===");
                //Récupération score d'attaque monstre selon type de monstre
                int dmgMonsterAttack = dungeon.room[i].monster.attack();
                //Soustraction des hp du joueur par les dégâts d'attaque
                hero.setHp(hero.getHp()-dmgMonsterAttack);
                //Vérification du type de monstre pour déterminer quelle arme le joueur devra utiliser
                if(dungeon.room[i].monster.MType.MName.equals("Barbarian")){
                    hero.setWeaponType(WeaponType.SWORD);
                }else{
                    hero.setWeaponType(WeaponType.WATER_FLASK);
                    //Si le monstre est un sorcier, il a une chance d'incapaciter le joueur pendant un tour
                    playerIncapacitated = Events.eventRandomizer(Stats.sorcererEventRate);
                }

                if(hero.getHp()<1){
                    System.out.println("");
                    System.out.println("=== GAME OVER ===");
                    System.out.println("You died with a lot of suffering");
                    return;
                }
                if(playerIncapacitated==true){
                    System.out.println("The monster knocked you down for one turn");
                    System.out.println("");
                    continue;
                }

                System.out.println("You have lost "+dmgMonsterAttack+" hp");
                System.out.println("You have only "+hero.getHp()+" hp remaining");

                //Si le joueur n'est pas mort, on demande une entrée à l'utilisateur
                //avec l'arme qui correspond à l'ennemi
                System.out.println("Type "+hero.WType.wName +" to fight back");
                //Récupération entrée utilisateur
                String playerAction = Main.getPlayerInput();
                //On vérifie si l'entrée utilisateur correspond à un type d'arme
                //Et si le type d'arme choisi correspond bien au type de monstre
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
            //Condition de fin de jeu: On sort de la boucle de la room 5, le monstre est battu = WIN
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
}
