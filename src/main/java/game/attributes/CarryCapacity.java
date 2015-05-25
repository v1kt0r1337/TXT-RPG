package game.attributes;

import java.util.ArrayList;

/**
 * The class CarryCapacity is a dependant attribute, 
 * that determire the characters weight capacity for items.
 * CarryCapacity is dependend on the attribute Strength.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarryCapacity extends DependantAttribute
{
    /**
     * Constructor for objects of class CarryCapacity
     * 
     * @param startingValue the start value of the CarryCapacity
     */
    public CarryCapacity(int startingValue)
    {
        super(startingValue);
    }
    
    /**
     * This metod calculates the CarryCapacity of the character.
     * 
     * @return the calculated finalValue
     */
    @Override public int calculateValue()
    {
        finalValue = getBaseValue();
        
        // Every point in strength adds 4 to carry capacity.
        // Every point in vitality adds 1 to carry capicity.
        int strength = otherAttributes.get(0).calculateValue();
        int vitality = otherAttributes.get(2).calculateValue();
        finalValue += (strength * 4) + (vitality);
         
        applyRawBonuses();
        applyFinalBonuses();
        
        return finalValue;
    }
}
