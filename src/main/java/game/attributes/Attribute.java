package game.attributes;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is for creating the primary Attributes like 
 * Strength, Agility and Intelligence for Character class.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attribute extends BaseAttribute
{
    private ArrayList<RawBonus> rawBonuses;
    private ArrayList<FinalBonus> finalBonuses;
    protected int finalValue;
    
    /**
     * Constructor for objects of class Attribute
     * 
     * @param startingValue the start value of the attribute
     */
    public Attribute(int startingValue)
    {
        super(startingValue);
        rawBonuses = new ArrayList<RawBonus>();
        finalBonuses = new ArrayList<FinalBonus>();
        
        finalValue = getBaseValue(); 
    }
    
    /**
     * Adds raw bonus, this are either permanent effects or item enchantments
     * 
     * @param bonus the added bonus.
     */
    public void addRawBonus(RawBonus bonus)
    {
        rawBonuses.add(bonus);
    }
 
    /**
     * Adds final bonus, these have temporary effects.
     * 
     * @param bonus the added bonus.
     */    
    public void addFinalBonus(FinalBonus bonus)
    {
        finalBonuses.add(bonus);
    }
    
    /**
     * Removes a raw bonus, for example unequiping an item
     * with a passive enchantment
     * 
     * @param bonus the added bonus.
     */      
    public void removeRawBonus(RawBonus bonus)
    {
        rawBonuses.remove(bonus);
    }

    public void removeEqualRawBonus(RawBonus bonus)
    {
        Iterator<RawBonus> it = this.rawBonuses.iterator();
        while (it.hasNext()) {
            RawBonus i = it.next();

            if (bonus.equals(i)) {
                it.remove();
                return;
            }
        }
    }



    /**
     * Removes a final bonus, for example a temporary buff
     * 
     * @param bonus the added bonus.
     */
    public void removeFinalBonus(FinalBonus bonus)
    {
        finalBonuses.remove(bonus);
    }
    
    /**
     * Applies all raw bonuses to the finalValue
     */
    protected void applyRawBonuses()
    {      
        // Adding value from rawBonus.
        int rawBonusValue = 0;
        double rawBonusMultiplier = 0;
        
        for (RawBonus bonus : rawBonuses) {
            rawBonusValue += bonus.getBaseValue();
            rawBonusMultiplier += bonus.getBaseMultiplier();
        }
        
        finalValue += rawBonusValue;
        finalValue *= (1 + rawBonusMultiplier);
    }
    
    
    /**
     * Applies all final bonuses to the finalValue
     * 
     */
    protected void applyFinalBonuses()
    {   
        // Adding value from finalBonus
        int finalBonusValue = 0;
        double finalBonusMultiplier = 0;
        
        for (FinalBonus bonus : finalBonuses) {
            finalBonusValue += bonus.getBaseValue();
            finalBonusMultiplier += bonus.getBaseMultiplier();
        }
        
        finalValue += finalBonusValue;
        finalValue *= (1 + finalBonusMultiplier);
    }
    
    /**
     * Calulates the final value. This method activates 
     * applyRawBonuses and applyFinalBonuses, for activation purposes.
     * 
     * @return the final calculated value
     */
    protected int calculateValue()
    {
        finalValue = getBaseValue();
        
        applyRawBonuses();
        applyFinalBonuses();
        
        return finalValue;
    }
    
    /**
     * Gets the calculated finalValue
     * 
     * @return the calculated final value.
     */
    public int getFinalValue()
    {
        return calculateValue();
    }
}
