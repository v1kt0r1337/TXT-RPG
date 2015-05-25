package game.items;

import game.spells.Spell;

/**
 * A subclass of Item ment for rings and amulets.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemAccessories extends ItemEquipable
{

    /**
     * Constructor for objects of class ItemAccessories
     * 
     * @param itemName the name of the item
     * @param itemSlot were in the item gets equiped
     * @param itemWeight the weight of the item
     * @param itemDescription the description of the item
     * @param onUseMsg the message that gets printed when the item get used.
     * @param spell the spell binded into the item.
     */
    public ItemAccessories(String itemName, String itemSlot, int itemWeight, 
                           String itemDescription, String onUseMsg, 
                           Spell spell)
    {
        super(itemName, itemWeight, itemDescription,
              onUseMsg, spell, itemSlot);
    }
}
