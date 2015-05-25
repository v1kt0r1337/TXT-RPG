package game.attributes;

/**
 * This class is currently just a test class, attack speed 
 * does not make sense during the current turn based gamesystem.
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackSpeed extends DependantAttribute
{
   
    /**
     * Constructor for objects of class AttackSpeed
     * 
     * @param startingValue the startingValue of AttackSpeed
     */
    public AttackSpeed(int startingValue)
    {
        super(startingValue);
    }

    /**
     * Calculates the attack speed.
     * 
     * @return the calculated value.
     */
    @Override protected int calculateValue()
    {
        finalValue = getBaseValue();
        
        // Every 5 points in dexterity adds 1 to attack speed

        int dexterity = otherAttributes.get(1).calculateValue();
        finalValue += dexterity / 5;
        
        applyRawBonuses();
        applyFinalBonuses();
        
        return finalValue;
    }
}
