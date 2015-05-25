package game.commands;

import game.items.Item;
import game.world.Location;
import game.Character;
import game.Player;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * The class Drop handles when a character 
 * drop an item from the inventory to the location.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandDrop extends Command
{

    
    /**
     * Constructor for objects of class CommandDrop
     */
    public CommandDrop()
    {
        super(DROP, DROP_DESC);
    }
    
    /**
     * Executes the Drop command.
     * 
     * @param c the characters that drops the item
     * @param cmdLine includes the drop command and hopefully the 
     *                item the character wants to drop.
     */
    public void execute(Character c, ArrayList<String> cmdLine)
    {
        this.c = c;
        if (c.getAmountOfInventoryItems() == 0) {
            System.out.println(NO_ITEM_TO_DROP);
        }
        else if (cmdLine.size() == 2) dropItemToLoc(cmdLine.get(1));
        
        else if (cmdLine.size() > 2) {
            String itemName = "";
            for (int i = 1; i < cmdLine.size(); i++) {
                itemName = itemName + " " + cmdLine.get(i);
            }
            dropItemToLoc(itemName.trim());  
        }
        else System.out.println(DROP_WHAT);
    }
    
    /**
     * Drops an item from the players inventory, to the Locations inventory.
     * 
     * @param itemName  the item that gets dropped.
     */
    private void dropItemToLoc(String itemName) 
    {
        if (itemName.equalsIgnoreCase("all")) {
            dropAllItemsToLoc();
            return;
        }

        Item theItem = c.dropItem(itemName);
        if (theItem != null) {
            c.getLocation().addItem(theItem);
            System.out.println(ITEM_TO_DROP1 + theItem.getItemName() + 
                               ITEM_TO_DROP2 + 
                               c.getLocation().getShortDescription()); 
        }
        else {
            System.out.println(DONT_HAVE_ITEM + itemName + "!");
        }
    }

    /**
     * Drops all items from the characters inventory, to the Locations inventory.
     */
    private void dropAllItemsToLoc()
    {
        for (Item item : c.getItemList()) {
            c.getLocation().addItem(item);
        }
        c.removeAllItemsFromInventory();
    }
}

//     
//         /**
//      * Drops an item from the characters inventory,
//      * based on the name of the item, and returns 
//      * the item that got dropped.
//      * 
//      * @param itemName  the item thats get dropped.
//      * @return the item thats get dropped.
//      */
//     private Item dropItem(String itemName)
//     {
//         // PERHAPS WE CAN USE getItem method
//         Item theItem = c.getItem(itemName);
//         if (theItem != null) {
//             
//         }
//         Iterator<Item> it = this.items.iterator();
//         Item theItem = null;
//         while (it.hasNext()) {
//             Item i = it.next();
//             
//             String item = i.getItemName();
//             if (itemName.equals(item)) {
//                 theItem = i;
//                 setCurrentWeight(getCurrentWeight()
//                                  - theItem.getItemWeight());                
//                 it.remove();
//                 return theItem;
//             }
//         }
//         return theItem;
//     }

