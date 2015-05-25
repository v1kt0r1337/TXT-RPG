package game.spells;

import java.util.ArrayList;

/**
 * The class Spell contains object of the class Magic.
 * When a spell is "casted by a character" it loops throught a
 * list of all the magic in the Spell, and its the Magic objects
 * that actually do thing.
 * 
 * The most commonly a spell only contain one Magic object.
 * 
 * Spells in a characters spell book should only contain MagicOnUse.
 * Spells binded into regular items can contain:
 * MagicOnUse and MagicEnchantmentPassive.
 * 
 * Spells binded into weapons can contain:
 * MagicOnUse, MagicEnchantmentPassive and MagicOnHit.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spell
{
    private ArrayList<Magic> spell;

    /**
     * Constructor for objects of class Spell
     */
    public Spell()
    {
        spell = new ArrayList<Magic>();
    }

    /**
     * Adds magic to the spell
     * 
     * @param magic the new magic property of the spell.
     */
    public void addMagic(Magic magic)
    {
        spell.add(magic); 
    }
    
    /**
     * gets magic from the spell
     * 
     * @param magicName the name of the magic.
     * @return One of the magic properties of the spell.
     */
    public Magic getMagic(String magicName)
    {
        for (Magic magic : spell)
        {
            if (magic.getMagicName().equals(magicName)) {
                return magic;
            }
        }
        //This method is not neccecarry YET, so it shouldnt happen.
        return null;
    }
    
    /**
     * This method is for activating a Spells MagicOnUse objects.
     * Spells in a characters spell book should only contain MagicOnUse magic.
     * 
     * Loops throught the spell and uses all the of the MagicOnUse properties of
     * the spell
     * 
     * @return A list containing all the magic of the spell.
     */
    public ArrayList<String> useSpell()
    {
        ArrayList<String> list = new ArrayList<String>();
        for (Magic magic : spell) {
            if (magic instanceof MagicOnUse) {
                list.add(magic.useMagic());
            }
        }
        return list;
    }
    
    /**
     * This method is for activating a Spells MagicEnchantmentPassive objects.
     * These are passive effects that gets activated when a character equips 
     * an item containing a spell with MagicEnchantmentPassive objects.
     * 
     * Loops throught the spell and uses all the magic properties of
     * the spell
     * 
     * @return A list containing all the magic of the spell.
     */
    public ArrayList<String> activateEnchantmentPassive()
    {
        ArrayList<String> list = new ArrayList<String>();
        for (Magic magic : spell) {
            if (magic instanceof MagicEnchantmentPassive) {
                list.add(magic.useMagic());
            }
        }
        return list;
    }
    
    /**
     * This method is for activating a Spells MagicOnHit objects.
     * Only weapons should contain Spells with MagicOnHit objects.
     * 
     * Loops through the spell and uses all the of the MagicOnHit properties of
     * the spell
     * 
     * @return A list containing all the magic of the spell.
     */
    public ArrayList<String> magicOnHit()
    {
        ArrayList<String> list = new ArrayList<String>();
        for (Magic magic : spell) {
            if (magic instanceof MagicOnHit) {
                list.add(magic.useMagic());
            }
        }
        return list;
    }
}
