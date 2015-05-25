package game.attributes;

/**
 * The class Health is a dependant attribute, 
 * that determire the characters max health.
 * Health is dependend on the attribute Vitality.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends DependantAttribute
{
    
    /**
     * Constructor for objects of class Health
     * 
     * @param startingValue the start value of characters
     *                      health. Before Vitality gets 
     *                      calculated in.
     */
    public Health(int startingValue)
    {
        super(startingValue);
    
    }
 
    /**
     * This metod calculates the Health of the character.
     * 
     * @return the calculated finalValue
     */    
    @Override public int calculateValue()
    {
        finalValue = getBaseValue();
        
        // Every point in vitality adds 5 to health.
        int vitality = otherAttributes.get(2).calculateValue();
        finalValue += vitality * 5;
        
        applyRawBonuses();
        applyFinalBonuses();
        
        return finalValue;
    }
}
