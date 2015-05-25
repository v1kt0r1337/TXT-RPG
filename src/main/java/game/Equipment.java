package game;

import game.items.*;

import java.util.ArrayList;
import java.util.Iterator;

/** 
 * The Character's equipment.
 * This class is dedicated 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equipment implements ResourceBundle
{
    private ArrayList<ItemEquipable> equipmentList;

    /**
     * Constructor for objects of class Equipment
     */
    public Equipment() 
    {
        equipmentList = new ArrayList<ItemEquipable>();
    }

    /**
     * Get the equipmentList
     * 
     * @return list of all the characters equiped items.
     */
    public ArrayList<ItemEquipable> getEquipmentList()
    {
        return equipmentList;
    }
    
    /**
     * Equips an item
     * 
     * @param newItem the item to be equiped.
     */
    public void equipItem(ItemEquipable newItem)
    {
        equipmentList.add(newItem);
    }
    
    /**
     * Remove an item from equipmentList.
     * 
     * @param itemSlot the that the character wants to remove an item from.
     * @return the item that gets unequiped.
     *
     */
    public Item unEquipItem(String itemSlot)
    {
        Iterator<ItemEquipable> it = this.equipmentList.iterator();
        while (it.hasNext()) {
            ItemEquipable i = it.next();   
            String item = i.getItemSlot();
            if (itemSlot.equals(item)) {                
                it.remove();
                return i;
            }
        }
        return null;
    }

    /**
     * Calculate the total weight of equipment
     * 
     * @return weight the weight of all the characters equipment
     */
    private int calculateItemWeight()
    {
        int weight = 0;
        for (ItemEquipable item : equipmentList) {
            weight += item.getItemWeight();
        }
        return weight;
    }
    
    /**
     * Get the total weight of equipment
     * 
     * @return weight the weight of all the characters equipment
     */
    public int getItemWeight()
    {
        return calculateItemWeight();
    }
    
    /**
     * Calculate the total armor value from equipment
     * 
     * @return the total amount of armor from equipment.
     */
    private int calculateItemArmorValue()
    {
        int armorValue = 0;
        for (ItemEquipable item : equipmentList) {
            if (item instanceof ItemArmor)
                armorValue += ((ItemArmor)item).getArmorValue();
        }
        return armorValue;
    }
    
    /**
     * Get the total armor value of equipment
     * 
     * @return the total armor value of all the characters equipment
     */
    public int getArmorValue()
    {
        return calculateItemArmorValue();
    }
    
    /**
     * Calculate the min dmg from equiped weapons.
     * 
     * @return the total min dmg from equiped weapons.
     */
    private int calculateItemMinDamage()
    {
        int minDmg = 0;
        for (ItemEquipable item : equipmentList) {
            if (item.getItemSlot().equals(HAND_SLOT)) {
                minDmg += ((ItemHandHeld)item).getMinDmg();
            }
        } 
        return minDmg;
    }
    
    /**
     * Calculate the max dmg from equiped weapons.
     * 
     * @return the total max dmg from equiped weapons.
     */
    private int calculateItemMaxDamage()
    {
        int maxDmg = 0;
        for (ItemEquipable item : equipmentList) {
            if (item.getItemSlot().equals(HAND_SLOT)) {
                maxDmg += ((ItemHandHeld)item).getMaxDmg();
            }
        } 
        return maxDmg;
    }
    
    /**
     * Gets the min dmg from equiped weapons.
     * 
     * @return the total min dmg from equiped weapons.
     */
    public int getItemMinDamage()
    {
        return calculateItemMinDamage();
    }
    
    /**
     * Gets the max dmg from equiped weapons.
     * 
     * @return the total max dmg from equiped weapons.
     */
    public int getItemMaxDamage()
    {
        return calculateItemMaxDamage();
    } 


    
    /**
     * Get amount of equiped items
     * 
     * @return amount of equiped items
     */
    public int getAmountOfEquipedItems()
    {
        return equipmentList.size();
    }
    
    /**
     * Checks if the handSlots are occupied.
     * 
     * @return  0 == no items, 1 == 1 item and 1handed, 
     *          2 == 2 items. 3 == 1 2handed item.
     */
    public int checkHandSlots()
    {
        int i = 0;
        for (ItemEquipable item : equipmentList) {
            if (item.getItemSlot().equals(HAND_SLOT)) {
                i++;
                if (((ItemHandHeld)item).reqTwoHands()) {
                    return 3;
                }
            }
        }
        return i;
    }
    
    /**
     * Checks how many of the ringSlots is occupied.
     * 
     * @return 0 == no items, 1 == 1 item, 2 == 2 items.
     */
    public int checkRingSlots()
    {
        int i = 0;
        for (ItemEquipable item : equipmentList) {
            if (item.getItemSlot().equals(HAND_SLOT)) {
                i++;
            }
        }
        return i;
    }
}