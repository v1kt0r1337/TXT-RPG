package game.commands;

import game.Character;

import java.util.ArrayList;

/**
 * The CommandInventory is for printing out the inventory
 * of the characters. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandInventory extends Command
{
    /**
     * Constructor for objects of class Command
     * 
     */
    public CommandInventory()
    {
        super(INVENTORY, INVENTORY_DESC);
    }
    
    /**
     * Prints out the inventory of the character
     * 
     * @param c the character whos inventory gets printed out.
     * @param cmdLine includes the command word and potential 
     *                extra words.
     */
    public void execute(Character c, ArrayList<String> cmdLine)
    {
        c.printInventory();
    }
}
