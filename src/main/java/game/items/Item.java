package game.items;

import game.ResourceBundle;
import game.spells.Spell;

import java.util.ArrayList;
import java.util.Random;

/**
 * The class Item is how items are implemented in
 * the text RPG.
 * 
 * This class should be abstract, but due to lazyness and
 * testing purposes Im holding it of for the moment.
 * 
 * @author Viktor
 * @version 12.05.2015
 */
public abstract class Item implements ResourceBundle
{
    protected String itemName;
    protected int itemWeight;
    protected String itemDescription;
    protected String onUseMsg;
    protected Spell spell;

    protected long id;
    
    /**
     * Constructor for objects of class Item
     * 
     * @param itemName the name of the item
     * @param itemWeight the weight of the item
     * @param itemDescription the description of the item
     * @param onUseMsg the message that gets printed when the item get used.
     * @param spell the spell binded into the item.
     */
    public Item(String itemName, int itemWeight, 
                String itemDescription, String onUseMsg, Spell spell)
    {
        // initialise instance variables
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        this.itemDescription = itemDescription;
        this.onUseMsg = onUseMsg;
        this.spell = spell;

        setId();
    }

    /**
     * Sets the id of the item.
     * The id is a random long number which should be enforced
     * to be unique.
     */
    public void setId()
    {
        Random random = new Random();
        id = random.nextLong();
    }

    /**
     * Gets the id of the item
     *
     * @return the personal id of the item
     */
    public long getId()
    {
        return id;
    }


    /**
     * Sets the item description of the item.
     * 
     * @param itemDescription The description of the item.
     */
    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }
    
    /**
     * Gets the item description of the item
     * 
     * @return itemDescription   description of the item
     */
    
    public String getItemDescription()
    {
        return this.itemDescription;
    }
    
    /**
     * Sets the items on use msg.
     * 
     * @param onUseMsg The description of the item.
     */
    public void setOnUseMsg(String onUseMsg)
    {
        this.onUseMsg = onUseMsg;
    }
    
    /**
     * Gets the item on use onUseMsg.
     * 
     * @return the msg the player gets when he uses the item.
     */
    
    public String getOnUseMsg()
    {
        return this.onUseMsg;
    }
    
    /**
     * Sets the weight of the item.
     * 
     * @param itemWeight the weight of the item
     */
    public void setItemWeight(int itemWeight)
    {
        this.itemWeight = itemWeight;
    }
    
    /**
     * Gets the weight of the item.
     * 
     * @return itemWeight   the weight of the item.
     */
    public int getItemWeight()
    {
        return this.itemWeight;
    }
    /**
     * Gives the item a name
     * 
     * @param itemName  The item name
     */
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }
    /**
     * Gets the name of the item
     * 
     * @return itemName
     */
    public String getItemName()
    {
        return this.itemName;
    }
    
    /**
     * returns out all information regarding an item.
     * 
     * @return itemInfo a String containing the information
     *                  regarding the item.
     */
    public String getAllItemInfo()
    {
        return (GENERIC_NAME + this.itemName + "%n" + GENERIC_DESC 
                + this.itemDescription + "%n" + GENERIC_WEIGHT + 
                this.itemWeight + "%n"); 
    } 
     
    /**
     * returns name and weight of an item.
     * 
     * @return itemInfo a String containing the name and weight
     *                  of the item.
     */
    public String getItemInfo()
    {
        return (GENERIC_NAME + this.itemName + "%n" + GENERIC_WEIGHT + 
                this.itemWeight + "%n"); 
    }
    
    /**
     * Uses the active ability of the item.
     * 
     * 
     * @return the spell as a String to the player.  
     */
    public ArrayList<String> useSpell()
    {
        return spell.useSpell();
    }

    public ArrayList<String> SpellOnHit()
    {
        return spell.magicOnHit();
    }

    public ArrayList<String> activateEnchantmentPassive()
    {
        return spell.activateEnchantmentPassive();
    }

//    Spells currently have no name, this should be easy to fix as they already have an assigned name in spellBank.
//    public String getSpellName()
//    {
//        return spell.getName();
//    }
}
