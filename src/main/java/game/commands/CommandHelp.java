package game.commands;

import game.Character;

import java.util.ArrayList; 

/**
 * The class CommandHelp is for printing out helping information
 * to the player.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandHelp extends Command
{

    
    /**
     * Constructor for objects of class CommandHelp
     * 
     */
    public CommandHelp()
    {
        super(HELP, HELP_DESC);
    }
    
    /**
     * Executes the help command.
     * 
     * @param c the character executing the command
     * @param cmdLine includes the help command and what the player
     *                wants help with. If it only contains help then
     *                it will print out all the command words.
     */
    public void execute(Character c, ArrayList<String> cmdLine)
    {
        CommandList commands = CommandList.getInstance();
        if (cmdLine.size() == 1) {
            System.out.println(HELP_MSG);
            commands.showAll();
        }
        
        else if (cmdLine.size() == 2) {
            Command cmd = commands.getCommand(cmdLine.get(1));
            if (cmd != null) System.out.println(cmd.getDesc());
            else System.out.println(HELP_NOCMD_MSG);
        }
        else System.out.println(HELP_NOCMD_MSG);
            
    }
}
