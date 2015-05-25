package game.attributes;


/**
 * The class RawBonus is currently handling permanent buffs 
 * and buffs from passive enchantments from items.
 * I think will splitt this class into two multiple classes
 * later on to easier differantiate between permanent increases
 * like Leveling up, and increases that will be removed ones the 
 * character unequips an item.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RawBonus extends BaseAttribute
{
    /**
     * Constructor for objects of class RawBonus
     * 
     * @param value of the buff
     * @param multiplier setting the multiplier at 1.0 will "double the value".
     */
    public RawBonus(int value, double multiplier)
    {
        super(value, multiplier);
    }


}
