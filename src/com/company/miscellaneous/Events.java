package com.company.miscellaneous;

/**
 * The purpose of this class is to store the values of events that will affect:
 * - the player
 * - monsters
 * The damage increased for monster is directly defined in the attack method.
 */
public class Events{
    public static boolean monsterKo;
    public static boolean playerKo;

    public static boolean eventRandomizer(double triggeringPercentage){
        boolean eventIsHappening = false;
        double criticalHitRand = Math.random();
        if (criticalHitRand<triggeringPercentage){
            eventIsHappening = true;
        }
        return eventIsHappening;
    }

}
