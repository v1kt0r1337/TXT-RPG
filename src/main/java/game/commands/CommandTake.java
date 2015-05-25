package game.commands;

import game.items.Item;
import game.Character;
import game.Player;

import java.util.ArrayList;

/**
 * This class enables the characters to pick up an item.
 * 
 * @author Viktor Setervang
 * @version 24.04.2015
 */
public class CommandTake extends Command
{
    /**
     * Constructor for objects of class CommandTake
     * 
     */
    public CommandTake()
    {
        super(TAKE, TAKE_DESC);
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
            System.out.println(TAKE_WHAT);
        }
        
        else if (cmdLine.size() == 2) pickUpItem(cmdLine.get(1));
        
        else if (cmdLine.size() > 2) {
            String itemName = "";
            for (int i = 1; i < cmdLine.size(); i++) {
                itemName = itemName + " " + cmdLine.get(i);
            }
            pickUpItem(itemName.trim());  
        }
        
    }
    
    /**
     * Picks up an item, if the character can carry it.
     * 
     * @param itemName the name of the item the character wants to take
     */
    private void pickUpItem(String itemName)
    {

        Item item = c.getLocation().getItem(itemName);

        if (item == null) {
            // if there is no second word, we don't know what to pick up...
            System.out.println(NO_ITEM_TO_ADD + itemName + "!");
            return;
        }
        
        else if (item.getItemWeight() > c.getMaxWeightFinalValue()) {
            System.out.println(itemName + TAKE_HEAVY_MSG1);
            if (c instanceof Player) {
                ((Player)c).getGame().incrementTime();
            }        
        }
        else if (c.getTotalCurrentWeight() + item.getItemWeight() 
                 > c.getMaxWeightFinalValue()) {
            System.out.println(TAKE_HEAVY_MSG2);
            
            if (c instanceof Player) {
                ((Player)c).getGame().incrementTime();
            }            
        }
        else {
            c.addItem(item);
            c.getLocation().removeItem(itemName);
            if (c instanceof Player) {
                ((Player)c).getGame().incrementTime();
            }
        }    
    }
}
