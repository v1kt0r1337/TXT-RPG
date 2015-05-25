package game.commands;


import game.Character;
import game.Player;

import java.util.ArrayList;

/**
 * The Command for quiting the game.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandQuit extends Command
{

    /**
     * Constructor for objects of class CommandQuit
     */ 
    public CommandQuit()
    {
        super(QUIT, QUIT_DESC);
    }
    
    /**
     * Executes the quit command.
     * 
     * @param c the character that wants to quit the game.
     * @param cmdLine list containing the quit command.
     */
    public void execute(Character c, ArrayList<String> cmdLine)
    {
        if (c instanceof Player) {
            ((Player)c).setGameOver(true);
        }
        else {
            return;
        }
    }
}
