package game.attributes;

/**
 * Initiative is attribute that is part of an equation calculating
 * which character that gets to act first.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Initiative extends DependantAttribute
{
    /**
     * Constructor for objects of class Initiative
     * 
     * @param startingValue the start value of characters
     *                      Initiative. Before the attributes 
     *                      gets calculated in.
     */
    public Initiative(int startingValue)
    {
        super(startingValue);
    }
    
    /**
     * This metod calculates the Initiative of the character.
     * 
     * @return the calculated finalValue
     */   
    @Override public int calculateValue()
    {
        finalValue = getBaseValue();
        
        // Every 2 point in dexterity adds 1 to Initiativ.
        // Every 6 point in intelligence adds 1 to Initiativ.
        int dexterity = otherAttributes.get(1).calculateValue();
        int intelligence = otherAttributes.get(3).calculateValue();
        finalValue += (dexterity / 2) + (intelligence / 6);
         
        applyRawBonuses();
        applyFinalBonuses();
        
        return finalValue;
    }
}

