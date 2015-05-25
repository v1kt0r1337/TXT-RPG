package game.attributes;

import java.util.ArrayList;

/**
 * This Class calculates the characters Mana.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mana extends DependantAttribute
{
    /**
     * Constructor for objects of class Mana
     * 
     * @param startingValue the start value of characters
     *                      mana. Before Intelligence gets 
     *                      calculated in.
     */
    public Mana(int startingValue)
    {
        super(startingValue);
    }
    
    /**
     * This metod calculates the Mana of the character.
     * 
     * @return the calculated finalValue
     */   
    @Override public int calculateValue()
    {
        finalValue = getBaseValue();
        
        // Every point in intelligence adds 5 to mana.

        int intelligence = otherAttributes.get(3).calculateValue();
        finalValue += intelligence * 5;
        
        applyRawBonuses();
        applyFinalBonuses();
        
        return finalValue;
    }
}