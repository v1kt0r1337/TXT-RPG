package game.commands;

import game.Character;
import game.Player;
import game.world.Location;
import game.enemyfactory.EnemyFactory;

import java.util.ArrayList;

/**
 * The class CommandGo handles the command word that
 * makes the character able to change location.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandGo extends Command
{
    private EnemyFactory enemyFactory;
    
    /**
     * Constructor for objects of class Command
     * 
     */
    public CommandGo()
    {
        super(GO, GO_DESC);
        enemyFactory = new EnemyFactory();
    }
    
    /**
     * execute the go command.
     * 
     * @param c the character goes back
     * @param cmdLine includes where the character wants to go.
     */
    public void execute(Character c, ArrayList<String> cmdLine)
    {
        if (cmdLine.size() == 2) {
            String dir = cmdLine.get(1);
            if (dir == BACK) {
                if (c instanceof Player) {
                    ((Player)c).getGame().incrementTime();
                }
                c.goBack(); 
                return;
            }
            Location newLoc = c.getLocation().getExit(dir);
        
            if (newLoc != null) {


                c.setLocation(newLoc);
                System.out.println(newLoc.getLongDescription());
                if (c instanceof Player) {
                    ((Player)c).getGame().incrementTime();
                }
                //if (c.hasVisited(newLoc)
                    //System.out.println(newLoc.getShortDescription());
                //else System.out.println(newLoc.getLongDescription());
    
            }
            else System.out.println(GO_NODIR_MSG);
        }
        else System.out.println(GO_NODIR_MSG);
    }
}
