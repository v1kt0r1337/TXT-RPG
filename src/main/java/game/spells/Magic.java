package game.spells;

import java.util.Random;
/**
 * This is the abstract class which all types of
 * magic inherits from. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Magic
{
    protected String magicName;
    protected String magicDesc;
    
    protected Effect effect;

    
    protected int minMagnitude;

    /**
     * Constructor for objects of class Magic
     * 
     * @param magicName the name of the magic.
     * @param magicDesc the description of the magic
     * @param effect the effect of the magic.
     * @param minMagnitude the minimum magnitude of the magic
     *                     if the magic does not have a maxMagnitude
     *                     then this will be the strength of the effect.
     */
    public Magic(String magicName, String magicDesc, Effect effect, 
                 int minMagnitude)
    {
        this.magicName = magicName;
        this.magicDesc = magicDesc;
        this.effect = effect;
        this.minMagnitude = minMagnitude;
    }

    /**
     * Gets the magicName
     * 
     * @return     the name of the magic
     */
    public String getMagicName()
    {
        return this.magicName;
    }
    
    /**
     * Gets the effect
     * 
     * @return     the effect
     */
    public Effect getEffect()
    {
        return this.effect;
    }
    
    /**
     * Gets the minMagnitude
     * 
     * @return     the minMagnitude
     */        
    public int getMinMagnitude()
    {
        return this.minMagnitude;
    }
    
    /**
     * Gets the description of the magic.
     * this method will vary depending on the type of magic.
     * 
     * @return String containing the magic description.
     */
    abstract String getMagicDescription();
    
    /**
     * Use magic
     * This should perhaps be returning an array instead of a string.
     * 
     * @return the magic as a concenated String.
     */
    abstract String useMagic();
}
