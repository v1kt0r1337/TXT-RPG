package game.items;

import game.spells.Spell;

/**
 * No objects of this class has been implemented yet.
 * There will probably be more changes needed for this class 
 * before anything gets implemented.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemHandHeldRanged extends ItemHandHeld
{

    /**
     * Constructor for objects of class ItemHandHeldRanged
     * 
     * @param itemName the name of the item
     * @param itemSlot were in the item gets equiped
     * @param itemWeight the weight of the item
     * @param itemDescription the description of the item
     * @param onUseMsg the message that gets printed when the item get used.
     * @param spell the spell binded into the item.
     * @param reqTwoHands do the item require two hands?
     * @param minDmg the minumum dmg the item can do.
     * @param maxDmg the maximum dmg the item can do
     */
    public ItemHandHeldRanged(String itemName, String itemSlot, int itemWeight,
                              String itemDescription, String onUseMsg, 
                              Spell spell, boolean reqTwoHands, int minDmg, 
                              int maxDmg)
    {      
        super(itemName, itemSlot, itemWeight, itemDescription, onUseMsg, spell,
              reqTwoHands, minDmg, maxDmg);
    }
}