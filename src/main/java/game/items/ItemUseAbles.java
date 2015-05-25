package game.items;

import game.spells.Spell;

/**
 * This Class is ment for use able items that is
 * not equiped (atleast not currently), examples
 * can be potions or similiar effects.
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemUseAbles extends Item
{
    private boolean consumAble;
    private int charges;

    /**
     * Constructor for objects of class ItemUseAbles
     * 
     * @param itemName the name of the item
     * @param itemWeight the weight of the item
     * @param itemDescription the description of the item
     * @param onUseMsg the message that gets printed when the item get used.
     * @param consumAble if the item is a consumable
     * @param spell the spell binded into the item.
     * @param charges how many charges the item has before its used up.
     */
    public ItemUseAbles(String itemName, int itemWeight, 
                    String itemDescription, String onUseMsg, 
                    boolean consumAble, Spell spell, int charges)
    {
        super(itemName, itemWeight, itemDescription,
              onUseMsg, spell);
              
        this.consumAble = consumAble;
        this.charges = charges;
              
    }
    
    /**
     * Checks if the item is consumeAble or not
     * 
     * @return true == yes, false == no.
     */
    public boolean isConsumAble()
    {
        return this.consumAble;
    }
     
    /**
     * Gets the amount of charges left on the item
     * 
     * @return the charges left on the item
     */
    public int getCharges()
    {
        return this.charges;
    }
    
    /**
     * Sets the amount of charges left on the item
     * 
     * @param charges the amount of charges left on the item.
     */
    public void setCharges(int charges)
    {
        this.charges = charges;
    }
}
