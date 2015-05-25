package game.spells;

/**
 * 
 * This class is ment for passive enchantments on items.
 * This will effect the RawBonus of attributes, and the effect will
 * be removed if the character unequips the items.
 * The logic for this will not be in this class.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicEnchantmentPassive extends Magic
{

    /**
     * Constructor for objects of class EnchantmentPassive
     * 
     * @param magicName the name of the magic.
     * @param magicDesc the description of the magic
     * @param effect the effect of the magic.
     * @param minMagnitude the minimum magnitude of the magic
     *                     if the magic does not have a maxMagnitude
     *                     then this will be the strength of the effect.
     */
    public MagicEnchantmentPassive(String magicName, String magicDesc,
                                   Effect effect, int minMagnitude)
    {
       super(magicName, magicDesc, effect, minMagnitude);
    }
    
    /**
     * get magic description when.
     * 
     * @return the desciption of the passive enchantment.
     */
    public String getMagicDescription()
    {
        return magicName + ":\n" + minMagnitude;
    }
    
    /**
     * THIS METHOD SHOULD PROBABLY BE REWRITTEN!
     * Use magic
     * 
     * @return the magic as a concenated String.
     */
    public String useMagic()
    {
        String magicEffect = effect.getChangeVariable();
        
        return minMagnitude + "#" + magicEffect +
               "#" + magicDesc;
    }
}
