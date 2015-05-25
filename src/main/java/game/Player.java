package game;

import game.world.Location;
import game.items.Item;
import game.commands.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ArrayDeque;

/**
 * The Player class represent whats unique for the Player
 * compared to the Character class.
 * 
 * The player is currently taking in THE Game as an object
 * so that the play effect time, this might be rewritten
 * later on.
 * 
 * @author Viktor
 * @version (a version number or a date)
 */
public class Player extends Character
{
    private CommandParser parser;
//     /** The places the player has been, used for smarter descriptions */
//     private HashSet<Location> visited;
    private boolean gameOver;
    private Game game;
    /**
     * The default constructor of the class Player. 
     * 
     * @param name the name of the player
     * @param description the description of the player.
     * @param raceTemplate the race of the player.
     * @param startLocation for the player.
     * @param game player does actually take in THE game object, the reason
     *             behind this is for the player to be able to effected Time.
     */
    public Player(String name, String description, String raceTemplate, 
                  Location startLocation, Game game)
    {
        // PLAYER_DESC should later be shifted out with something more dynamic.
        super(name, PLAYER_DESC, raceTemplate);
        this.game = game;
        parser = new CommandParser();
        setLocation(startLocation);
        banditFaction = 0;
    }
    
        /** Execute one command. */
    public void action() 
    {   
        ArrayList<String> cmdLine = parser.getCommand();
        Command cmd = commands.getCommand(cmdLine.get(0).toLowerCase());
        
        if (cmd == null) cmd = commands.getCommand(HELP);
        else cmd.execute(this, cmdLine);
    }
    
    /**
     * Get the gameOver status
     * 
     * @return gameOver status, false == continue playing, true == quit.
     */
    public boolean isGameOver()
    {
        return this.gameOver;
    }
    
    /**
     * Sets the gameOver status
     * 
     * @param status if true then the game is over.
     */
    public void setGameOver(boolean status)
    {
        this.gameOver = status;
    }
    
    /**
     * Overwrites super method.
     * 
     * Adds an item to the players inventory.
     * 
     * @param item  the item that gets added.
     */
    @Override public void addItem(Item item) 
    {
        this.items.add(item);
        setCurrentWeight(getCurrentWeight() + item.getItemWeight());
        
        System.out.println(ITEM + item.getItemName() + 
                           ITEM_ADDED_INV);
    }
    
    /**
     * Gets the game object, this method only has one use, to make the
     * player object able to influence the moveCounter (time).
     * 
     * @return THE GAME
     */
    public Game getGame()
    {
        return game;
    }
    
    /**
     * Sets the new current Location the Character is in.
     * When moving to another location, we must remove ourselves
     * from the list of entities in the old location, and add to the new.
     * 
     * @param nextLocation the new Location the player has entered.
     */
    public void setLocation(Location nextLocation)
    {
        if (currentLocation != null) {
            formerLocations.add(currentLocation);
            currentLocation.removeEntity(this);
        }
        currentLocation = nextLocation;
        currentLocation.addEntity(this);
        getGame().setPlayerSameZone(false);
    }    
}
