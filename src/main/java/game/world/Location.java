package game.world;

import game.Entity;
import game.Character;
import game.Player;

import game.ResourceBundle;
import game.items.Item;

import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Class Location - a Location in the RPG game.
 *
 * This class is part of the TXT RPG application. 
 *
 * A "Location" represents one location in the scenery of the game.  
 * It is connected to other Locations via exits.  
 * For each existing exit, the Location stores a reference to the 
 * neighboring Location.
 * 
 * @author  Viktor
 * @version 03.05.2015
 */

public class Location implements ResourceBundle
{
    private String description;
    private HashMap<String, Location> exits;
    private ArrayList<Item> items;
    private HashMap<Long, Item> itemMap;
    private HashMap<Long, Entity> entityIdMap;
    
    private ArrayList<Entity> entityList;
    
    // this field should only be accessed by "user input"
    private HashMap<String, Entity> entityNameMap;
    
    
    /**
     * Create a Location described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The Location's description.
     */
    public Location(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Location>();
        items = new ArrayList<Item>();
        itemMap = new HashMap<Long, Item>();
        entityIdMap = new HashMap<Long, Entity>();
        entityNameMap = new HashMap<String, Entity>();
        entityList = new ArrayList<Entity>();
    }

    /**
     * Define an exit from this Location.
     * @param direction The direction of the exit.
     * @param neighbor  The Location to which the exit leads.
     */
    public void setExit(String direction, Location neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the Location
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the Location in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this Location
     */
    public String getLongDescription()
    {
        if ((items.size() > 0) && (entityList.size() == 1)) { 
            return PLAYER_LOCATION1 + description + ".\n" + 
                   getExitString() + ".\n" + PLAYER_LOCATION_ITEM;
        }
        else if ((items.size() == 0) && (entityList.size() > 1)) {
            return PLAYER_LOCATION1 + description + ".\n" + getExitString() 
                   + ".\n\n" + getEntityDescription();
        }
        else if ((items.size() > 0) && (entityList.size() > 1)) {
            return PLAYER_LOCATION1 + description + ".\n" + getExitString()
                   + ".\n" + PLAYER_LOCATION_ITEM + "\n" 
                   + getEntityDescription();
        
        }
        else {
            return PLAYER_LOCATION1 + description + ".\n" + getExitString();
        }
    }

    /**
     * Return a string describing the Location's exits, for example
     * "Exits: north west".
     * @return Details of the Location's exits.
     */
    private String getExitString()
    {
        String returnString = EXITS;
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Adds an entity to the location.
     * 
     *@param entity the entity thats added to the location. 
     */
    public void addEntity(Entity entity) 
    {
        entityIdMap.put(entity.getId(), entity);
        entityList.add(entity);
        entityNameMap.put(entity.getName(), entity);
    }
    
    /**
     * Gets an entity from the location.
     * This is the prefered method.
     * 
     * @param id id of the entity
     * @return the entity.
     */
    public Entity getEntity(long id) {
        return entityIdMap.get(id);
    }
    
    /**
     * Gets an entity from the location.
     * if possible, use getEntity instead.
     * 
     * @param name the name of the entity
     * @return the entity
     */
    public Entity getEntityByName(String name)
    {
        return entityNameMap.get(name);
    }   
    
    
    /**
     * Checks if the entity is in the location.
     * 
     * @param theEntity the to be compared
     * @return true if its already here, false if its not.
     */
    public boolean isEntityInLocation(Entity theEntity) 
    {
        for (Entity entity : entityList) {
            if (entity == theEntity) {
                return true;
            }  
        }
        return false;
        // if java 8 support is 100% guaranteed: 
        //return entityList.stream().anyMatch(e -> e == theEntity);
        
    }

    /**
     * Removes and return entity from the location.
     * This will not work properly for the entityNameMap, atm it's to big of a chance that multiple entities have the
     * same name.
     * 
     * @param entity to be removed for the location.
     * @return the entity that gets removed.
     */    
    public Entity removeEntity(Entity entity) {
        entityList.remove(entity);
        entityNameMap.remove(entity.getName());
        return entityIdMap.remove(entity.getId());
    }
    
    /**
     * Gets the locations entityList.
     * 
     * @return entityList.
     */
    public ArrayList<Entity> getEntityList()
    {
        return entityList;
    }
    
    /**
     * Adds an item 
     * 
     * @param newItem   The item that gets added to the Location.
     */
    public void addItem(Item newItem)
    {
        this.items.add(newItem); 
        long itemId = newItem.getId();
        itemMap.put(itemId, newItem);
    }

    /**
     * Get an item from this location.
     * IMPORTANT, THIS METHOD DO NOT REMOVE THE ITEM FROM THE LOCATION.
     *
     * @param itemName the name of the item.
     * @return item with maching name.
     */
    public Item getItem(String itemName)
    {
        for (Item item : items) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * Return the Location that is reached if we go from this Location 
     * to the "direction". If there is no Location in that direction, 
     * return null.
     * @param direction The exit's direction.
     * @return The Location in the given direction.
     */
    public Location getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * Access the Locations items.
     */
    public void printLocationItems()
    {
        for (Item item : items) {
            System.out.printf(item.getItemInfo());
        }
    }
    
    /**
     * Gets the information of all the items in the location.
     * 
     * @return a string containing the item info of the Location
     */ 
    public String getLocationItems()
    {
        String itemInfo = "";
        int i = 0;
        for (Item item : items) {
            i += 1;
            itemInfo = itemInfo + item.getAllItemInfo() + "%n";
        }
        
        if (i == 0) {
            return NO_ITEM_IN_LOC;
        }
        else if (i == 1) {
            String amountOfItems = ONE_ITEM_IN_LOC;
            return amountOfItems + itemInfo;
        }
        else {
            String amountOfItems = MULT_ITEMS_IN_LOC1 + i + MULT_ITEMS_IN_LOC2;
            return amountOfItems + itemInfo;
        }
    }

    /**
     * Get the description of the entities in the location
     * 
     * @return the description of entities.
     */
    private String getEntityDescription()
    {
        //we can here differantiate between different entities with
        // the instanceof EntitySubClass 
        // if needed we should make this into multiple metods, depending on
        // Entity Subclass.
        String entities = "There are someone here:\n";
        for (Entity entity : entityList) {
            if ((entity instanceof Character) && !(entity instanceof Player)) {
                entities += entity.getDescription() + "\n";
            }
        }
        return entities;
    }

    /**   
     * removes an item from the Location inventory
     * and adds an item to the players inventory
     *
     * @param itemName  The item to remove from Location and give to player
     * @return theItem    the item that gets returned
     */    
    public Item removeItem(String itemName)
    { 
        Iterator<Item> it = this.items.iterator();
        Item theItem = null;
        while (it.hasNext()) {
            Item i = it.next();
            
            String item = i.getItemName();
            if (itemName.equals(item)) {
                theItem = i;
                it.remove();
                itemMap.remove(theItem.getId());
                return theItem;
            }
        }
        return theItem;
    }
}