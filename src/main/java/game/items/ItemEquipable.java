package game.items;

import game.spells.Spell;

/**
 * Abstract class ItemEquipable is a subclass of Item, ment as a 
 * super class for all the equipable Item classes.
 * 
 * @author Viktor Setervang
 * @version 12.05.2015
 * 
 * 
 */
public abstract class ItemEquipable extends Item
{
    /**
     * itemSlot is were the item gets equiped
     */
    protected String itemSlot;
    
    /**
     * Constructor for objects of class ItemArmor
     * 
     * @param itemName the name of the item
     * @param itemWeight the weight of the item
     * @param itemDescription the description of the item
     * @param onUseMsg the message that gets printed when the item get used.
     * @param spell the spell binded into the item.
     * @param itemSlot is were the item gets equiped
     */
    public ItemEquipable(String itemName, int itemWeight, 
                         String itemDescription, String onUseMsg, 
                         Spell spell, String itemSlot)
    {
        super(itemName, itemWeight, itemDescription,
              onUseMsg, spell);
        this.itemSlot = itemSlot;
    }
    
    /**
     * Gets the item slot of the selected item.
     * 
     * @return the item slot
     */
    public String getItemSlot()
    {
        return itemSlot;
    }
}
