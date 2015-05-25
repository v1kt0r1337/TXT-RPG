package game.commands;
import java.util.ArrayList;

import game.ResourceBundle;
import game.Character;

/**
 * Abstract class Commands is used by command words.
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Command implements ResourceBundle
{
    private String name;
    private String description;
    protected Character c;
    
    /**
     * The constructor of the Command class.
     * 
     * @param name the name of the command.
     * @param description the description of the command
     */
    public Command(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
   
    /**
     * This method is overriden by the subclasses.
     * The purpose is to execute the command.
     * 
     * @param c is the character that executes the command.
     * @param commandLine is a list of all the words in the command
     *                    including the commmand.
     */
    public abstract void execute(Character c, ArrayList<String> commandLine);
    
    /**
     * Gets the name of the Command
     * 
     * @return command name
     */
    public String getName()
    {
        return this.name;
    }
    
        /**
     * Gets the description of the Command
     * 
     * @return command description
     */
    public String getDesc()
    {
        return this.description;
    }
}
