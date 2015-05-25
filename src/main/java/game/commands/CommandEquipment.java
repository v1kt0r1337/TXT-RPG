package game.commands;

import game.items.*;
import game.Character;

import java.util.ArrayList;

/**
 * This command is for printing out the items that the 
 * character has equiped..
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandEquipment extends Command
{
    /**
     * Constructor for objects of class CommandEquipment
     */
    public CommandEquipment()
    {
        super(EQUIPMENT, EQUIPMENT_DESC);
    }

    /**
     * Prints out the equipment of the character
     * 
     * @param c the character whos equipment gets printed out.
     * @param cmdLine includes the command word and potential 
     *                extra words.
     */
    @Override
    public void execute(Character c, ArrayList<String> cmdLine)
    {
        if (c.getEquiped().getEquipmentList().size() == 0) {
            System.out.println(NO_ITEM_EQUIPED);
        }
        else {
            for (Item item : c.getEquiped().getEquipmentList()) {
                System.out.printf(item.getItemInfo());
            }
        }
    }    
    
}
