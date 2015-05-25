package game.commands;

import game.items.*;
import game.Player;
import game.Character;
import game.attributes.RawBonus;

import java.util.ArrayList;

/**
 * This class is supposed to handle the logic of unequiping items.
 * Most of the logic is however residing in the Character class, this needs to be fixed...
 *
 * @author Viktor Setervang 
 * @version (a version number or a date)
 */
public class CommandUnEquip extends Command
{
   
    /**
     * Constructor for objects of class CommandEquip
     */
    public CommandUnEquip()
    {
        super(UNEQUIP, UNEQUIP_DESC);
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
            System.out.println(UNEQUIP_WHAT);
        }
        
        else if (cmdLine.size() == 2) unEquipItem(cmdLine.get(1));
        
        else if (cmdLine.size() > 2) {
            String itemName = "";
            for (int i = 1; i < cmdLine.size(); i++) {
                itemName = itemName + " " + cmdLine.get(i);
            }
            unEquipItem(itemName.trim());  
        }
    }
    
    /**
     * Unequips the targeted item.
     * 
     * @param itemName the name of the item the character wants to unequip.
     */
    private void unEquipItem(String itemName)
    {

        
        if (c.getEquiped().getEquipmentList().size() == 0) {
            System.out.println(NO_ITEM_EQUIPED);
            return;
        }

        if (itemName.equalsIgnoreCase("all")) {
            for (ItemEquipable item : c.getEquiped().getEquipmentList()) {
                c.addItem(item);
                if (c instanceof Player) {
                    System.out.println("Buffs from: " + itemName + " removed");
                }
                deactivateEnchantments(item.activateEnchantmentPassive());

            }
            c.removeEquipedItems();
            return;
        }

        ItemBank itemBank = new ItemBank();
        ItemEquipable item = ((ItemEquipable)itemBank.getItem(itemName));

        Item unequiped = c.getEquiped().unEquipItem(item.getItemSlot());
        if (unequiped != null) {
            c.addItem(unequiped);
            if (c instanceof Player) {
                System.out.println("Buffs from item " + itemName + " is removed");
            }
            deactivateEnchantments(unequiped.activateEnchantmentPassive());
        }
        else {
            System.out.println(DONT_HAVE_ITEM + " " + itemName);
        }  
    }

    /**
     * activate on equip magic.
     * If the item contain a spell that contains MagicEnchantmentPassive
     * then these will get activated.
     *
     * @param spell the spell that gets used.
     */
    private void deactivateEnchantments(ArrayList<String> spell)
    {
        for (String magic1 : spell)
        {
            String[] magic = magic1.split("#");
            removePermanentEffect(magic, Integer.parseInt(magic[0]));
        }
    }

    private void removePermanentEffect(String[] magic, int magnitude)
    {
        if (EFFECT_INCREASE_MAXWEIGHT_EFFECTS.equals(magic[1])) {
            // the second param "0" should not be hardcoded,
            // this is multiplier.
            RawBonus increaseWeightLimit = new RawBonus(magnitude, 0);
            c.getMaxWeight().removeEqualRawBonus(increaseWeightLimit);
        } else if (EFFECT_VITALITY.equals(magic[1])) {
            RawBonus vitality = new RawBonus(magnitude, 0);
            c.getVitality().removeEqualRawBonus(vitality);
        } else if (EFFECT_STRENGTH.equals(magic[1])) {
            RawBonus strength = new RawBonus(magnitude, 0);
            c.getStrength().removeEqualRawBonus(strength);
        } else if (EFFECT_INTELLIGENCE.equals(magic[1])) {
            RawBonus intelligence = new RawBonus(magnitude, 0);
            c.getIntelligence().removeEqualRawBonus(intelligence);
        } else if (EFFECT_DEXTERITY.equals(magic[1])) {
            RawBonus dexterity = new RawBonus(magnitude, 0);
            c.getDexterity().removeEqualRawBonus(dexterity);
        }
    }
}

