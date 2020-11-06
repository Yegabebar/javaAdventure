package com.company.miscellaneous;

/**
 * The purpose of this class is to store the values of events that will affect:
 * - the player
 * - monsters
 * The damage increased for monster is directly defined in the attack method.
 */
public abstract class Events{
    public static boolean monsterKo;
    public static boolean playerKo;

    /**
     * This function exists to determine if an event will happen or not, with a percentage of occurence
     * according to the kind of event we want to trigger.
     * @param triggeringPercentage
     * @return a boolean indicating if the event to trigger will happen or not.
     */
    public static boolean eventRandomizer(double triggeringPercentage){
        boolean eventIsHappening = false;
        double criticalHitRand = Math.random();
        //If the randomly-generated number is greater than the percentage we provide to the function,
        if (criticalHitRand<triggeringPercentage){
            eventIsHappening = true; //Then the event will happen.
        }
        //Else if the random number is greater, then the boolean will stay false so the event to trigger won't happen
        return eventIsHappening;
    }

}
