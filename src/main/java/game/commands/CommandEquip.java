package game.commands;

import game.Character;
import game.items.*;

import java.util.ArrayList;

/**
 * This class enables characters to equip items.
 *
 * This class is currently a subclass of CommandsUsingSpells, this is a bad and very lazy decision, which has given
 * the class 2 methods which it doesnt need (aka needs refactoring).
 *
 * 
 * @author Viktor Setervang 
 * @version 12.05.2015
 */
public class CommandEquip extends CommandsUsingSpells
{
   
    /**
     * Constructor for objects of class CommandEquip
     */
    public CommandEquip()
    {
        super(EQUIP, EQUIP_DESC);
    }
    
    /**
     * Executes the Take command.
     * 
     * @param c the character that executes the command.
     * @param cmdLine contains from element 1-> the name of the
     *                item.
     */
    @Override
    public void execute(Character c, ArrayList<String> cmdLine)
    {
        this.c = c;
        if (cmdLine.size() == 1) {
            System.out.println(EQUIP_WHAT);
        }
        
        else if (cmdLine.size() == 2) equipItem(cmdLine.get(1));
        
        else if (cmdLine.size() > 2) {
            String itemName = "";
            for (int i = 1; i < cmdLine.size(); i++) {
                itemName = itemName + " " + cmdLine.get(i);
            }
            equipItem(itemName.trim());  
        }
    }
    
    /**
     * Equips the item as long as its an equip able item.
     * 
     * @param itemName the name of the item the character wants to equip.
     */
    private void equipItem(String itemName)
    {
        if (!(c.getItem(itemName) instanceof ItemEquipable)) {
            System.out.println(CANT_EQUIP_THAT_ITEM + itemName);
            return;
        }
        
        ItemEquipable item = ((ItemEquipable)c.getItem(itemName));
        c.equipItem(item);
        activateEnchantments(item.activateEnchantmentPassive());
    }

    /**
     * activate on equip magic.
     * If the item contain a spell that contains MagicEnchantmentPassive
     * then these will get activated.
     *
     * @param spell the spell that gets used.
     */
    private void activateEnchantments(ArrayList<String> spell)
    {
        for (String magic1 : spell)
        {
            String[] magic = magic1.split("#");
            targetOfMagic = c;
            System.out.println("(" + targetOfMagic.getName() + ": " + magic[2]);
            permanentEffect(magic, Integer.parseInt(magic[0]));
        }
    }
}
