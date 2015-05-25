package game.enemyfactory;

import game.ResourceBundle;
import game.world.Location;
import game.items.ItemBank;

/** 
 * EnemyFactory is part of the factory pattern that creates this 
 * worlds enemies.
 * 
 * EnemyFactory's only job is creating enemies.
 * By encapsulating enemy creation, we only have one
 * place to make modifications
 * 
 * @author Viktor Setervang
 * @version 2.0
 */ 
public class EnemyFactory implements ResourceBundle 
{

    /**
     * The makeEnemy method creates enemies based on its parameters.
     * 
     * @param newEnemyType the type of enemy.
     * @param itemSet the set of item the enemy will equip. If no valid
     *                itemSet is given, then the enemy wont have any items
     *                equiped.
     *                
     * @param loc the location the enemy gets placed in.
     * 
     * @return the newly created enemy.
     */
    public Enemy makeEnemy(String newEnemyType, String itemSet, Location loc)
    { 
        Enemy newEnemy = null;
        
        if (newEnemyType.equals(HUMAN_BANDIT)) {
            newEnemy = new HumanBandit();   
        } 
        
        else if (newEnemyType.equals(DWARF_BANDIT)) {
            newEnemy = new DwarfBandit();
        
        }
        
        else if (newEnemyType.equals(ELF_BANDIT)) {  
            newEnemy = new ElfBandit();  
        }
        
        else return null;
        
        // sets the location of the enemy.
        newEnemy.setLocation(loc);
        // We can here implement some if checks to see
        // what type of items want to give to the enemy.
        // these can for instance be based on the players level
        if (itemSet.equals(CRUDE_ITEMS)) {
            return giveCrudeItemToEnemy(newEnemy);
        }
        
        else {
            return newEnemy;
        }
    }
    
    /**
     * Gives the enemy crude items
     * 
     * @param newEnemy the enemy to equip the items.
     * @return a combat ready enemy.
     */
    private Enemy giveCrudeItemToEnemy(Enemy newEnemy)
    {
        ItemBank itemBank = new ItemBank();
        
        newEnemy.equipItem(itemBank.getItem(ITEM_CRUDE_IRON_SWORD_NAME));
        newEnemy.equipItem(itemBank.getItem(ITEM_CRUDE_LEATHER_ARMOR_NAME));
        newEnemy.equipItem(itemBank.getItem(ITEM_CRUDE_LEATHER_BOOTS_NAME));
        newEnemy.equipItem(itemBank.getItem(ITEM_CRUDE_LEATHER_HELM_NAME));
        newEnemy.equipItem(itemBank.getItem(ITEM_CRUDE_LEATHER_GLOVES_NAME));
        newEnemy.equipItem(itemBank.getItem(ITEM_CRUDE_LEATHER_PANTS_NAME));
        newEnemy.equipItem(itemBank.getItem(ITEM_CRUDE_LEATHER_SHOULDERS_NAME));
        
        return newEnemy;
    }
    
}