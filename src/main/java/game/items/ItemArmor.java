package game.items;

import game.spells.Spell;

/**
 * A subclass of Item ment for Armor.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemArmor extends ItemEquipable
{
    private int armorValue;
    
    /**
     * Constructor for objects of class ItemArmor
     * 
     * @param itemName the name of the item
     * @param itemWeight the weight of the item
     * @param itemDescription the description of the item
     * @param onUseMsg the message that gets printed when the item get used.
     * @param spell the spell binded into the item.
     * @param itemSlot were in the item gets equiped
     * @param armorValue the armor value of the item
     */
    public ItemArmor(String itemName, String itemSlot, int itemWeight, 
                     String itemDescription, String onUseMsg, 
                     Spell spell, int armorValue)
    {
        super(itemName, itemWeight, itemDescription,
              onUseMsg, spell, itemSlot);
        this.armorValue = armorValue;
    }
    
    /**
     * Method to get the armorValue
     * 
     * @return armorValue 
     */
    public int getArmorValue()
    {
        return this.armorValue;
    }
    
    /**
     * Method to set the armorValue
     * 
     * @param armorValue the new armorValue.
     */
    public void setArmorValue(int armorValue)
    {
        this.armorValue = armorValue;
    }
}
