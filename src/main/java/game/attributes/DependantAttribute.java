package game.attributes;

import java.util.ArrayList;

/**
 * This class is for dependant attributes.
 * For instance CarryCapacity is dependant of Strength.
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DependantAttribute extends Attribute
{
    protected ArrayList<Attribute> otherAttributes;
    
    /**
     * Constructor for objects of class DependantAttribute
     * 
     * @param startingValue the starting value of the dependant attribute.
     */
    public DependantAttribute(int startingValue)
    {
        super(startingValue);
        
        otherAttributes = new ArrayList<Attribute>();
    }
    
    /**
     * This is just an example of how we can calculate the
     * dependent attribute.
     * 
     * @return the final Value of the dependend attribute.
     */
    @Override protected int calculateValue()
    {
        int attributes = 0;
        // This would only work of all the attributes give same bonus.
        for (Attribute attribute : otherAttributes) {
            attributes += attribute.getFinalValue();
        }
        finalValue = getBaseValue();
        finalValue += attributes * 5;
        
        
        applyRawBonuses();
        applyFinalBonuses();
        
        return finalValue;
    }
    


    /**
      * Adds the other attributes used for calculation.
      * 
      * @param otherAttributes the characters attributes.
      */
    public void addOtherAttributes(ArrayList<Attribute> otherAttributes)
    {
        this.otherAttributes = otherAttributes;
    }
}