package game.commands;

import game.Character;
import game.Player;
import game.items.*;
import game.attributes.*;

import java.util.ArrayList;
import java.util.Random;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The class CommandUse is for when a 
 * character uses an item.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandUse extends CommandsUsingSpells
{

    /**
     * Constructor for objects of class CommandUse
     */
    public CommandUse()
    {
        super(USE, USE_DESC);
    }

    /**
     * Executes the use command.
     * 
     * @param c the character that uses the command.
     * @param cmdLine includes what the character want to use
     */    
    public void execute(Character c, ArrayList<String> cmdLine)
    {
        this.c = c;
        if (cmdLine.size() == 1) {
            System.out.println(USE_WHAT_MSG);
        }
        
        if (cmdLine.size() == 2) useItem(cmdLine.get(1));
        
        if (cmdLine.size() > 2) {
            String itemName = "";
            for (int i = 1; i < cmdLine.size(); i++) {
                itemName = itemName + " " + cmdLine.get(i);
            }
            useItem(itemName.trim());  
        }
        
    }
    
   /**
     * character uses an item
     * If the item is a consumable and out of charges
     * then the item gets removed from the characters 
     * inventory.
     * 
     * @param itemName  the item the player uses.
     */
    private void useItem(String itemName) 
    {
        Item theItem = c.getItem(itemName);
        
        if (theItem != null && theItem instanceof ItemUseAbles) {

            System.out.println(theItem.getOnUseMsg());
            if (((ItemUseAbles)theItem).isConsumAble()) {
                ((ItemUseAbles)theItem).setCharges(((ItemUseAbles)theItem)
                    .getCharges() - 1);
                
                if (((ItemUseAbles)theItem).getCharges() >= 0) {
                    c.dropItem(itemName);
                }
            }

            System.out.println(THROW_AWAY_EMPTY + theItem.getItemName() + ".");
            if (theItem.useSpell() != null) {
                useSpell(theItem.useSpell());
            }
            else {
                System.out.println(GENERIC_NOTHING_HAPPENS3);
            }
        }
        else if (theItem != null) {
            System.out.println(theItem.getOnUseMsg());
            if (theItem.useSpell() != null) {
                useSpell(theItem.useSpell());
            }
            else {
                System.out.println(GENERIC_NOTHING_HAPPENS2);
            }
        }
        else {
            System.out.println(DONT_HAVE_ITEM + itemName + "!");
        }
    }
    
   /**
     * Character uses an item spell.
     * 
     * @param spell the spell that gets used. 
     */
    private void useSpell(ArrayList<String> spell)
    {
        if (c instanceof Player) {
            ((Player)c).getGame().incrementTime();
        }
        for (String magic1 : spell)
        {
            String[] magic = magic1.split("#");
            if (MAGIC_TARGET_SELF.equals(magic[0])) {
                targetOfMagic = c;
                activateMagic(magic);
            } else if (MAGIC_TARGET_ENEMY.equals(magic[0])) {
                targetOfMagic = target;
                activateMagic(magic);
            } else {
                System.out.println("MAGIC EFFECT WITH INVALID TARGET");
                }
        }

        if (c instanceof Player) {
            ((Player) c).getGame().incrementTime();
        }
    }
}

