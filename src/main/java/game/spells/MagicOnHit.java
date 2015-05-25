package game.spells;

/**
 * This class is for weapons with enchanted with magic on hit.
 * 
 * The parameter totalCost and chargers are optional, but made with
 * the intent to balance out very powerful MagicOnHit effects.
 * I've decided how to implement these yet, 
 * perhaps setting totalCost to 0 or -1 and charges to -1.
 *  
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicOnHit extends MagicOnUse
{
    //this field is not implemented yet.
    //private int charges;
    
    /**
     * Constructor for objects of class MagicOnHit
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
     *                  
     * param charges combined with totalCost this will determine how hits it 
     *                takes before the item needs to be recharged.
     */
    public MagicOnHit(String magicName, String magicDesc, Effect effect, 
                      int minMagnitude, int maxMagnitude, String target, 
                      int duration, int totalCost)
    {
        super(magicName, magicDesc, effect, minMagnitude, maxMagnitude, target, 
              duration, totalCost);
        
        //this.charges = charges;
    }
}
