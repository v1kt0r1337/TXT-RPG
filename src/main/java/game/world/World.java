package game.world;

import game.ResourceBundle;
import game.items.ItemBank;
import game.enemyfactory.*;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * The class World contains all the Locations of the txt RPG.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World implements ResourceBundle
{
    private HashMap<String, Location> locations;
    private ArrayList<Location> locList;
    private ItemBank itemBank;

    private EnemyFactory enemyFactory;
    /**
     * Constructor for objects of class World
     */
    public World()
    {
        itemBank = new ItemBank();
        locations = new HashMap<String, Location>();
        locList = new ArrayList<Location>();
        enemyFactory = new EnemyFactory();
        createLocations();
    }
    
    /**
     * Get a list of the locations.
     * 
     * @return list of locations.
     */
    public ArrayList<Location> getLocList()
    {
        return locList;
    }
    
    
    /**
     * Get the location with the specified name
     * 
     * @param name  the name of the location.
     * @return the location with the specified name.
     */
    public Location getLocation(String name)
    {
        return locations.get(name);
    }

    /**  
     * Add a named location 
     * 
     * @param name  the name of the location 
     * @param loc   the location.
     */
    public void addLocation(String name, Location loc) {
        locations.put(name, loc);
    }

    /**  
     * Create and add a location
     * 
     * @param name  the name of the location
     * @param description   description of the location
     * 
     */
    public void addLocation(String name, String description) {
        Location loc = new Location(description);
        locations.put(name, loc);
        locList.add(loc);
    }

    /** 
     * Remove and return a location
     * 
     * @param name the name of the location to remove
     * @return the location that gets removed.
     */
    public Location removeLocation(String name) {
        return locations.remove(name);
    }   
    
    /**
     * Creates the locations in the world.
     */
    public void createLocations() //return type HashMap<String,Location>
    {
        Location outside, theater, pub, lab, office;
        //locations = new HashMap<String,Location>();
        // create the Locations
        addLocation(STARTLOC_NAME, STARTLOC_DESC);
        addLocation(THEATRE_NAME, THEATRE_DESC);
        addLocation(PUB_NAME, PUB_DESC);
        addLocation(LAB_NAME, LAB_DESC);
        addLocation(OFFICE_NAME, OFFICE_DESC); 
        
        outside = locations.get(STARTLOC_NAME);
        theater = locations.get(THEATRE_NAME);
        pub = locations.get(PUB_NAME);
        lab = locations.get(LAB_NAME);
        office = locations.get(OFFICE_NAME);
        
        outside.setExit(DIR_EAST, theater);
        outside.setExit(DIR_SOUTH, lab);
        outside.setExit(DIR_WEST, pub);
        
        theater.setExit(DIR_WEST, outside);
        enemyFactory.makeEnemy(HUMAN_BANDIT, CRUDE_ITEMS, theater);
        enemyFactory.makeEnemy(DWARF_BANDIT, CRUDE_ITEMS, theater);
        enemyFactory.makeEnemy(ELF_BANDIT, CRUDE_ITEMS, theater);


        pub.setExit(DIR_EAST, outside);
        pub.addItem(itemBank.getItem(ITEM_HAMMER_NAME));
        pub.addItem(itemBank.getItem(ITEM_CURSEDSPEAR_NAME));
        pub.addItem(itemBank.getItem(ITEM_CURSEDSPEAR_NAME));
        //FinalBonus class is not finished.
        pub.addItem(itemBank.getItem(ITEM_ENERGYDRINK_NAME));
        pub.addItem(itemBank.getItem(ITEM_ENERGYDRINK_NAME));
        pub.addItem(itemBank.getItem(ITEM_STEROIDS_NAME));
        pub.addItem(itemBank.getItem(ITEM_BIG_SYRINGE_NAME));
        pub.addItem(itemBank.getItem(ITEM_AMULET_MINOR_ALL_STATS_NAME));


        lab.addItem(itemBank.getItem(ITEM_STEROIDS_NAME));
        enemyFactory.makeEnemy(ELF_BANDIT, CRUDE_ITEMS, lab);
        lab.setExit(DIR_NORTH, outside);
        lab.setExit(DIR_EAST, office);

        office.setExit(DIR_WEST, lab);
        
        //return this.locations;
    }
}
