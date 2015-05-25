package game.commands;

import game.Character;
import game.Player;
import game.world.Location;

import java.util.ArrayList;

/**
 * CommandBack handles the logic of going back.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandBack extends Command
{

    
    /**
     * Constructor for objects of class CommandBack
     * 
     */
    public CommandBack()
    {
        super(BACK, BACK_DESC);
    }
    
    /**
     * execute the back command.
     * 
     * @param c the character goes back
     * @param cmdLine list....
     */
    public void execute(Character c, ArrayList<String> cmdLine)
    {
        if (cmdLine.size() == 1) {
            if (c instanceof Player) {
                ((Player)c).getGame().incrementTime();
            }
            c.goBack();
        }
        else System.out.println(GO_NODIR_MSG);
    }
}
        