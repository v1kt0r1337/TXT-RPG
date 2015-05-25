package game;

import game.items.*;
import game.attributes.*;
import game.world.*;
import game.commands.CommandList;
import game.enemyfactory.Enemy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ArrayDeque;
import java.util.Random;

/**
 * Abstract class Character - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Character extends Entity implements ResourceBundle

{
    protected ArrayList<Item> items;
    // equipment is equiped items.
    protected Equipment equipment;
    
    protected String raceTemplate;
    
    protected Attribute strength;
    protected Attribute dexterity;
    protected Attribute vitality;
    protected Attribute intelligence;
    
    protected Initiative initiative;
    protected Health maxHealth;
    protected Mana maxMana;
    
    protected int currentHp;
    protected int currentMana;
    
    //The dmg before item calc.
    protected Damage damageBonusFromAttr;
    
    protected CarryCapacity maxWeight;
    protected int currentWeight;
    

    // factions, faction values define friends from foes.
    // these should be initialized somehow.
    protected int townsMenFaction;
    protected int banditFaction;
    protected int playerFaction;
    
    
    protected Location currentLocation;
    protected ArrayDeque<Location> formerLocations;
    
    protected CommandList commands;
    
    /**
     * The constructor for objects of the Character class.
     * 
     * @param name the name of the character
     * @param description the description of the character
     * @param raceTemplate the race of the character.
     */
    public Character(String name, String description, String raceTemplate)
    {
        super(name, description);
        
        commands = CommandList.getInstance();
        
        initiative = new Initiative(0);
        maxHealth = new Health(0);
        maxMana = new Mana(0);
        maxWeight = new CarryCapacity(0);
        damageBonusFromAttr = new Damage(0);
        
        this.raceTemplate = raceTemplate;
        
        createInitialAttributes(raceTemplate);
        calculateDependantAttributes();
        
        items = new ArrayList<Item>();
        equipment = new Equipment();

        
        currentHp = maxHealth.getFinalValue(); 

        currentMana = maxMana.getFinalValue();
        currentWeight = 0;

        formerLocations = new ArrayDeque<Location>();
        
    }
    
    /**
     * The actions the character is cabable to do.
     */
    public abstract void action();    
    
    /**
     * get the current Location the character is in.
     * 
     * @return the Location the character  is in. 
     */
    public Location getLocation()
    {
        return this.currentLocation;
    }
    
    /**
     * Sets the new current Location the Character is in.
     * When moving to another location, we must remove ourselves
     * from the list of entities in the old location, and add to the new.
     * 
     * @param nextLocation   the new Location the player has entered.
     */
    public void setLocation(Location nextLocation)
    {
        if (currentLocation != null) {
            formerLocations.add(currentLocation);
            currentLocation.removeEntity(this);
        }
        currentLocation = nextLocation;
        currentLocation.addEntity(this);  
    }
    
    /**
     * Gets the currentHp of the character.
     * 
     * @return the currentHp of the character
     */
    public int getCurrentHp()
    {
        return currentHp;
    }
    
    /**
     * Sets the currentHp of the character
     * 
     * @param newCurrentHp the new current hp of the character.
     */
    public void setCurrentHp(int newCurrentHp)
    {
        currentHp = newCurrentHp;
    }
    
    /**
     * Gets the maxHealth of the character
     * 
     * @return the maxHealt of the character.
     */
    public int getMaxHealth() 
    {
        return maxHealth.getFinalValue();
    }
    
    /**
     * Get the equiped items of the character
     * 
     * @return equiped
     */
    public Equipment getEquiped()
    {
        return equipment;
    }
    
    /**
     * Equip an item
     * This method contains tons of logic and should
     * perhaps be split up into multiple methods.
     * 
     * @param theItem the item the character equips.
     */
    public void equipItem(Item theItem)
    {
        if (theItem instanceof ItemEquipable) {
            ItemEquipable item = ((ItemEquipable)theItem);
            dropItem(item.getItemName());
        
            if ((item instanceof ItemHandHeld) && 
                !(item instanceof ItemHandHeldRanged)) {
                equipItemHandSlot((ItemHandHeld)item);
                return;
            }
            else if (item.getItemSlot().equals(RING_SLOT)) {
                equipItemRingSlot((ItemAccessories)item);
            }
            else {
                Item oldItem = equipment.unEquipItem(item.getItemSlot());
                equipment.equipItem(item);
            
                if (oldItem == null) {
                    return;
                }
                else {
                    addItem(oldItem);
                }
            }
        }
        
        else {
            System.out.println(CANT_EQUIP_THAT_ITEM + theItem.getItemName());
        }
    }
    
    /**
     * The method equipItem(Item item) will call this method if the item is 
     * is a ring.
     * 
     * @param item the item to equip in handSlot.
     */    
    private void equipItemRingSlot(ItemAccessories item)
    {
        if (equipment.checkRingSlots() == 2) {
            addItem(equipment.unEquipItem(item.getItemSlot()));
            equipment.equipItem(item);
        }
        else {
            equipment.equipItem(item);
        }
    }
    
    /**
     * The method equipItem(Item item) will call this method if the item is of
     * instance ItemHandHeld
     * 
     * @param item the item to equip in handSlot.
     */
    private void equipItemHandSlot(ItemHandHeld item)
    {
        if (!item.reqTwoHands() && (equipment.checkHandSlots() < 2)) {
            equipment.equipItem(item);
        }
        
        // "param item" is not 2 handed and in the equipment there is 
        // 2 items in handSlots or a 2handed item. 
        else if (!item.reqTwoHands() && ((equipment.checkHandSlots() == 2) 
                 || (equipment.checkHandSlots() == 3))) {
            /*removes an item from equipment handSlot 
            * and adds it to the inventory */
            addItem(equipment.unEquipItem(item.getItemSlot()));
            //Adds the item to the equipment handSlot.
            equipment.equipItem(item);
        }
        
        // the param item requires 2 hands. 
        else {
            // no items in handSlots
            if (equipment.checkHandSlots() == 0) equipment.equipItem(item);
            
            // only one item equiped in handSlot, and its either 1h and 2handed.
            else if ((equipment.checkHandSlots() == 1) || 
                     (equipment.checkHandSlots() == 3)) {
                addItem(equipment.unEquipItem(((ItemHandHeld)item)
                        .getItemSlot()));
                equipment.equipItem(item);
            }
            
            // there are 2 1handed items in the handSlots, 
            // so we remove both before adding 2handed.
            else {
                addItem(equipment.unEquipItem(((ItemHandHeld)item)
                        .getItemSlot()));
                addItem(equipment.unEquipItem(((ItemHandHeld)item)
                        .getItemSlot()));
                equipment.equipItem(item);
            }
        } 
    }
    
    /**
     * Adds an item to the characters inventory.
     * 
     * @param item  the item that gets added.
     */
    public void addItem(Item item) 
    {
        this.items.add(item);
        setCurrentWeight(getCurrentWeight() + item.getItemWeight());
        
        //System.out.println(ITEM + item.getItemName() + 
        //                   ITEM_ADDED_INV);
    }
    
    /**
     * Gets an item from the players inventory
     * 
     * @param itemName  the name of the item.
     * @return The item with that name.
     */
    public Item getItem(String itemName)
    {
        Iterator<Item> it = this.items.iterator();
        Item theItem = null;
        while (it.hasNext()) {
            Item i = it.next();
            
            String item = i.getItemName();
            if (itemName.equals(item)) {
                theItem = i;
                return theItem;
            }
        }
        return theItem;
    }
    
     /**
      * Gets the items of the character inventory
      * (not equiped items).
      *
      * @return the items of the character.
      */
     public ArrayList<Item> getItemList()
     {
         return items;
     }

    /**
     * Drops an item from the characters inventory,
     * based on the name of the item, and returns 
     * the item that got dropped.
     * 
     * @param itemName  the item thats get dropped.
     * @return the item thats get dropped.
     */
    public Item dropItem(String itemName)
    {
        // PERHAPS WE CAN USE getItem method
        Iterator<Item> it = this.items.iterator();
        Item theItem = null;
        while (it.hasNext()) {
            Item i = it.next();
            
            String item = i.getItemName();
            if (itemName.equals(item)) {
                theItem = i;
                setCurrentWeight(getCurrentWeight()
                                 - theItem.getItemWeight());                
                it.remove();
                return theItem;
            }
        }
        return theItem;
    }
    
    /**
     * This method sends the required information to 
     * the dependant attributes for calculation.
     * 
     */
    public void calculateDependantAttributes()
    {
        ArrayList<Attribute> allAttr = new ArrayList<Attribute>();
        allAttr.add(strength);
        allAttr.add(dexterity);
        allAttr.add(vitality);
        allAttr.add(intelligence);
        
        initiative.addOtherAttributes(allAttr);
        maxHealth.addOtherAttributes(allAttr);
        maxMana.addOtherAttributes(allAttr);
        maxWeight.addOtherAttributes(allAttr);
        damageBonusFromAttr.addOtherAttributes(allAttr);
    }
    
    /**
     * get the initiative value 
     * 
     * @return initiative
     */
    public int getInitiative()
    {
        return initiative.getFinalValue();
    }
    
    /**
     * Do an initiative roll
     * 
     * @return the rolled value + initiative
     */
    public int rollInitiative()
    {
        Random rand = new Random();
        int min = 1;
        int max = 20;
        int roll = rand.nextInt((max - min) + 1) + min;
        return roll + getInitiative();
    }
    
    /**
     * Get currentWeight of inventory
     * 
     * @return   currentWeight
     */
    public int getCurrentWeight() 
    {
        return this.currentWeight;
    }    
    
    /**
     * Gets the currentWeight of inventory and equipment.
     * 
     * @return the total weight 
     */
    public int getTotalCurrentWeight()     
    {
        return getCurrentWeight() + equipment.getItemWeight();
    }

    /**
     * Set currentWeight
     * 
     * @param newCurrentWeight the new currentWeight
     */
    public void setCurrentWeight(int newCurrentWeight)
    {
        this.currentWeight = newCurrentWeight;
    }
    
    /**
     * Checks if the player can store one more item.
     * 
     * @return     True if the player can store more items. 
     */
    public boolean canCarryMore()
    {
        if (getTotalCurrentWeight() >= getMaxWeightFinalValue()) {
            return false;
        }
        return true;
    }
    
        /**
     * Checks size of the players inventory
     * 
     * @return size  the size of the inventory.
     */
    public int getAmountOfInventoryItems() 
    {
        return items.size();
    }

    /**
     * Get maxWeight
     * 
     * @return maxWeight field variable.
     */
    public CarryCapacity getMaxWeight()
    {
        return maxWeight;
    }

    public Attribute getVitality()
    {
        return vitality;
    }

    public Attribute getStrength()
    {
        return strength;
    }

    public Attribute getIntelligence()
    {
        return intelligence;
    }

    public Attribute getDexterity()
    {
        return dexterity;
    }

    /**
     * Get maxWeight
     * 
     * @return maxWeight
     */
    public int getMaxWeightFinalValue()
    {
        return maxWeight.getFinalValue();
    }

    /**
     * Checks size of the players inventory + equipment.
     * 
     * @return the total amount of items the player got.
     */
    public int getAmountOfItems() 
    {
        return items.size() + equipment.getAmountOfEquipedItems();
    }
    
    /**
     * Get the characters damage bonus from attributes
     * 
     * @return dmg bonus
     */
    public int getDamageBonusFromAttributes()
    {
        return damageBonusFromAttr.getFinalValue();
    }
    
    /**
     * Prints the attributes of the character. 
     */
    public void printAttributes()
    {
        System.out.println("Strength: " + strength.getFinalValue());
        System.out.println("Dexterity: " + dexterity.getFinalValue());
        System.out.println("Vitality: " + vitality.getFinalValue());
        System.out.println("Intelligence: " + intelligence.getFinalValue());
        System.out.println("");
        System.out.println("Initiative: " + initiative.getFinalValue());
        System.out.println("Weight: " + getTotalCurrentWeight() + "/" 
                           + maxWeight.getFinalValue());
        System.out.println("Health: " + currentHp + "/" 
                           + maxHealth.getFinalValue());
        System.out.println("Mana: " + currentMana + "/" 
                           + maxMana.getFinalValue());
        System.out.println("Damage bonus from attributes: " 
                           + damageBonusFromAttr.getFinalValue());
        System.out.println("Weapon Damage: " + equipment.getItemMinDamage() 
                           + "-" + equipment.getItemMaxDamage());
        System.out.print("Total damage: ");
        System.out.print(damageBonusFromAttr.getFinalValue() 
                         + equipment.getItemMinDamage());
        System.out.print("-");
        System.out.println(damageBonusFromAttr.getFinalValue() 
                           + equipment.getItemMaxDamage());
        System.out.println("Armor: " + equipment.getArmorValue());
        
        System.out.println("Items equiped: " 
                           + equipment.getAmountOfEquipedItems());
    }
    
    /**
     * Prints the character sheet and calls the printAttribute() method.
     * 
     */
    public void printCharacterSheet()
    {
        System.out.println("Name: " + name);
        System.out.println("Race: " + raceTemplate);
        System.out.println("Description: " + description);
        System.out.println("");
        
        printAttributes();
    }
    
    /**
     * This method creates the initial attributes based
     * on the characters race template.
     * 
     * @param raceTemplate  the race/subrace of the character.
     */
    public void createInitialAttributes(String raceTemplate)
    {
        // Could have used switch, will make a Race class later on.
        
        if (raceTemplate.equals(HUMAN)) {
            useHumanTemplate();
        }
        
        else if (raceTemplate.equals(ELF)) {
            useElfTemplate();
        }
        
        else if (raceTemplate.equals(DWARF)) { 
            useDwarfTemplate(); 
        }
    }
    
    /**
     * Human race template.
     */
    public void useHumanTemplate()
    {
        strength = new Attribute(10);
        dexterity = new Attribute(10);
        vitality = new Attribute(10);
        intelligence = new Attribute(10);
    }

    /**
     * Elf race template.
     */
    public void useElfTemplate()
    {
        strength = new Attribute(8);
        dexterity = new Attribute(12);
        vitality = new Attribute(8);
        intelligence = new Attribute(12);
    }
  
    
    /**
     * Dwarf race template.
     */
    public void useDwarfTemplate()
    {
        strength = new Attribute(12);
        dexterity = new Attribute(8);
        vitality = new Attribute(12);
        intelligence = new Attribute(8);
    }
    
    /**
     * sets faction value
     * 
     * @param newValue the new faction value.
     */
    public void setTownsMenFaction(int newValue)
    {
        townsMenFaction = newValue;
    }
    
    /**
     * sets faction value
     * 
     * @param newValue the new faction value.
     */
    public void setBanditFaction(int newValue)
    {
        banditFaction = newValue; 
    }
    
    /**
     * sets faction value
     * 
     * @param newValue the new faction value.
     */   
    public void setPlayerFaction(int newValue)
    {
        playerFaction = newValue;
    }
    
    /**
     * Gets the faction value.
     * 
     * @return the faction value.
     */
    public int getTownsMenFaction()
    {
        return townsMenFaction;
    }

    /**
     * Gets the faction value.
     * 
     * @return the faction value.
     */
    public int getBanditFaction()
    {
        return banditFaction; 
    }
    
    /**
     * Gets the faction value.
     * 
     * @return the faction value.
     */
    public int getPlayerFaction()
    {
        return playerFaction;
    }
   
    /**
     * print out the inventory list. 
     */
    public void printInventory()
    {   
        if (items.size() == 0) {
            System.out.println(NO_ITEM_INV);
        }
        else {
            for (Item item : items) {
                System.out.printf(item.getItemInfo());
            }
        }
    }
    
    /**
     * Goes back to the last Location the player was in.
     * Perhaps some of this logic should be moved to Back Command?
     * 
     */
    public void goBack()
    {
        if (formerLocations.size() != 0) {
            Location loc = formerLocations.getLast();
            formerLocations.removeLast();
            System.out.println(loc.getLongDescription());
            setLocation(loc);
        }
        else System.out.println(currentLocation.getLongDescription());
    }

    /**
     * Cheat method to remove all equiped items
     */
    public void removeEquipedItems()
    {
        this.equipment =  new Equipment();
    }

    /**
     * "Removes" all items from the inventory.
     */
    public void removeAllItemsFromInventory()
    {
        this.items = new ArrayList<Item>();
    }
}