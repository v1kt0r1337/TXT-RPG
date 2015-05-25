package game.commands;

import game.Character;

import java.util.ArrayList;

/**
 * Command for getting the characters character sheet.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandCharacterSheet extends Command
{

    /**
     * Constructor for objects of class CommandBack
     */
    public CommandCharacterSheet()
    {
        super(CHARACTER_SHEET, CHARACTER_SHEET_DESC);
    }
    
    /**
     * Prints out the character sheet.
     * 
     * @param c is the character
     * @param cmdLine is all the command words, currently only element 0
     *                matter.
     */
    public void execute(Character c, ArrayList<String> cmdLine)
    {
        c.printCharacterSheet();
        /*
         * Perhaps later on implementing a way for player to
         * access other peoples character sheet.
         */
        
    }
}
        