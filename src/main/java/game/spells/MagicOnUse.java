package game.spells;

/**
 * 
 * This class is for magic casted like normal spells and for on use items.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicOnUse extends Magic
{
    protected String target;
    protected int maxMagnitude;
    protected int duration;
    protected int totalCost;
    /**
     * Constructor for objects of class MagicOnUse
     *  
     * @param magicName the name of the magic.
     * @param magicDesc the description of the magic
     * @param effect the effect of the magic.
     * @param minMagnitude the minimum strength of the magic
     * @param maxMagnitude the maximum strength of the magic
     * @param target the target of the magic, can either be self or the 
     *               the person hit.
     * 
     * @param duration how long the magic will last, if set at -1 then it
     *                 will have an immediate effect.
     *                 
     * @param totalCost how much the magic will cost. 
     */
    public MagicOnUse(String magicName, String magicDesc, Effect effect, 
                      int minMagnitude, int maxMagnitude, String target, 
                      int duration, int totalCost)
    {
        super(magicName, magicDesc, effect, minMagnitude);
        
        
        //if duration is set to -1 then it's a permanent or immediate effect.
        this.duration = duration;
        this.totalCost = totalCost;
        this.maxMagnitude = maxMagnitude;
        this.target = target;
    }
    
    /**
     * Gets the maxMagnitude
     * 
     * @return the maxMagnitude
     */
    public int getMaxMagnitude()
    {
        return this.maxMagnitude;
    }
   
    /**
     * get the totalCost
     * 
     * @return the totalCost
     */
    public int getTotalCost()
    {
        return this.totalCost;
    }
    
    /**
     * get magic description when no mana cost
     * 
     * @return the magic description.
     */
    public String getMagicDescription()
    {
        if (minMagnitude == maxMagnitude) {
            return magicName + ":\n" + minMagnitude;
        }
        else {
            return magicName + ":\n" + minMagnitude + "-" + maxMagnitude;
        }
    }
    
    /**
     * THIS METHOD NEEDS TO BE REWRITTEN!
     * Use magic
     * 
     * @return the magic as a concenated String.
     */
    public String useMagic()
    {
        String magicEffect = effect.getChangeVariable();
        
        return target + "#" + magicEffect + "#" + minMagnitude + "#" 
               + maxMagnitude + "#" + duration + "#" + totalCost + 
               "#" + magicDesc;
    }
    
}
