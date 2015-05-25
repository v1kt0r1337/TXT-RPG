package game.items;

import game.spells.Spell;

import java.util.Random;

/**
 * This class is subclass of Item, ment for items 
 * like weapon, shields and other items that you need 
 * your hands to hold.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemHandHeld extends ItemEquipable
{
    private boolean reqTwoHands;
    private int minDmg;
    private int maxDmg;

    /**
     * Constructor for objects of class ItemHandHeld
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
    public ItemHandHeld(String itemName, String itemSlot, int itemWeight, 
                        String itemDescription, String onUseMsg, Spell spell, 
                        boolean reqTwoHands, int minDmg, int maxDmg)
    {      
        super(itemName, itemWeight, itemDescription,
              onUseMsg, spell, itemSlot);
        
        this.reqTwoHands = reqTwoHands;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;   
    }

    /**
     * 
     * @return     True if the item require two hands. 
     */
    public boolean reqTwoHands()
    {
        return this.reqTwoHands;
    }
    
    /**
     * 
     * @return the minimum dmg a weapon can do
     */
    public int getMinDmg()
    {
        return minDmg;
    }
    
    /**
     * 
     * @return the maximum dmg a weapon can do
     */
    public int getMaxDmg()
    {
        return maxDmg;
    }
    
    /**
     * Returns a pseudo-random number between minDmg and maxDmg, inclusive.
     * 
     * @return between min and max, inclusive.
     */
    public int randDmg() 
    {
        Random rand = new Random();
        int randomDmg = rand.nextInt((this.maxDmg - this.minDmg) + 1) 
                                     + this.minDmg;

        return randomDmg;
    }
    
    
}
