package game.commands;

import game.Character;

import java.util.ArrayList;

/**
 * The class CommandLook is for the player to look 
 * for items or other thing of interest.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandLook extends Command
{

    
    /**
     * Constructor for objects of class CommandLook
     */
    public CommandLook()
    {
        super(LOOK, LOOK_DESC);
    }
    
    /**
     * Executes the look command.
     * 
     * @param c the character that looks
     * @param cmdLine contains the command and perhaps other words,
     *                these words will currently not be used.
     */
    public void execute(Character c, ArrayList<String> cmdLine)
    {
        System.out.printf(c.getLocation().getLocationItems());
    }
}
