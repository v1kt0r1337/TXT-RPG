package game.attributes;

/**
 * This class calculates a characters Damage.
 * Weapon does currently not affect the values of the Damage Class.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Damage extends DependantAttribute
{
    /**
     * Constructor for objects of class Damage
     * 
     * @param startingValue the starting value of the characters damage.
     */
    public Damage(int startingValue)
    {
        super(startingValue);
    }
    
    /**
     * Calculates the damage values.
     * 
     * @return the finalValue of damage
     */
    @Override public int calculateValue()
    {
        finalValue = getBaseValue();
        
        // THESE ARE JUST TEST VALUES, NO ATTEMPT TO BALANCE YET
        // Every 3 point in strength adds 1 to damage        
        // Every 5 point in dexterity adds 1 to damage

        int strength = otherAttributes.get(0).calculateValue();
        int dexterity = otherAttributes.get(1).calculateValue();
        finalValue += (strength / 3) + (dexterity / 5);
        
        applyRawBonuses();
        applyFinalBonuses();
        
        return finalValue;
    }
}
