package game.commands;
import java.util.HashMap;
import game.ResourceBundle;
/**
 * the class CommandList contains a HashMap of all the viable commands.
 * 
 * The class is using the "new" singleton pattern.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandList implements ResourceBundle
{
//     private Player p;
    private HashMap<String, Command> validCommands;
    
    // creates the only instance of CommandList.
    private static CommandList instance = new CommandList();
    /**
     * Constructor for objects of class CommandList
     * Its private so no class other then itself can call it.
     */
    private CommandList()
    {
        validCommands = new HashMap<String, Command>();
        makeList();
    }

    /**
     * Gets the single instance of the commandList.
     * Its static so no different variations of it exist.
     * 
     * @return the instance of the CommandList
     */
    public static CommandList getInstance() 
    {
        return instance;
    }
    
    /**
     * The command list
     * 
     */
    public void makeList()
    {
        addCommand(new CommandAttack());
        addCommand(new CommandBack());
        addCommand(new CommandCharacterSheet());
        addCommand(new CommandDrop());
        addCommand(new CommandEquip());
        addCommand(new CommandEquipment());
        addCommand(new CommandHelp());
        addCommand(new CommandGo());
        addCommand(new CommandLook());
        addCommand(new CommandTake());
        addCommand(new CommandInventory());
        addCommand(new CommandUnEquip());
        addCommand(new CommandUse());
        addCommand(new CommandQuit());
    }
    
    
    /**
     * Add a command.
     * @param command the new command object.
     */
    public void addCommand(Command command) 
    {
        validCommands.put(command.getName(), command);
    }
    
    
    /**
     * Find a Command by name.
     * @param commandWord the command naame.
     * @return the Command object, or null if no command
     * matching the name exists.
     */
    public Command getCommand(String commandWord)
    {
        return validCommands.get(commandWord);
    }

    /**
     * Check if a command name is valid.
     * @param commandName the command name to check.
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String commandName)
    {
        return validCommands.containsKey(commandName);
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll()
    {
        for (String command : validCommands.keySet()) {
            System.out.print(command + " ");
        }
        System.out.println();
    }

        
}
