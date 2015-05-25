package game.enemyfactory;

import game.ResourceBundle;
import game.world.*;

import java.util.Scanner;
import java.util.ArrayList;
/**
 * This class is not part of the text RPG.
 * Its ment as a simulator, and regarding on choice it can simuluate
 * how the EnemyFactory pattern works or how casting and polymorphism works.
 * 
 * The EnemyFactoy only needs to know 2 things. A valid String representing
 * the type of enemy, and a String representing what (or if) type of items
 * the enemy should use. 
 * 
 * Due to perhaps a slight design fault, the Enemy also needs an object 
 * of the class Location.
 * 
 * This creates a strong encapsulation between the enemyfactory itself
 * and the outside packages, and between the classes inside the pattern.
 * 
 * @author Viktor Setervang
 * @version 05.05.2015
 */
public class EnemyFactorySimulator implements ResourceBundle 
{
    // these two fields is only for simulation purposes.
    private World world;
    private Location loc;
    // Create the factory object
    private EnemyFactory enemyFactory;
    
    /**
     * This is the constructor of the EnemyFactorySimulator.
     * It instantiates the dynamic types of the fields.
     */
    public EnemyFactorySimulator()
    {
        world = new World();
        loc = world.getLocation(STARTLOC_NAME);
        enemyFactory = new EnemyFactory();
        
        chooseSimulation();
    }
    
    /**
     * In this method the user is able to choose what to simulate.
     * 
     * If the user writes "normal" it will show how the EnemyFactory works 
     * when used from an other class. 
     * 
     * If the user writes "polymorphism" it will show how polymorphism, 
     * static and dynamic type works in java.
     * 
     */
    public void chooseSimulation()
    {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println(SIMULATE_WHAT); 
        boolean validInput = false;
        String nextMethod = "";
        while (!validInput) {
            nextMethod = userInput.next();
            if (nextMethod.equals(SIMULATE_NORMAL) ) {
                validInput = true;
                simulateFactory();
            }
   
            else if (nextMethod.equals(SHOWCASE_POLYMORP)) {
                validInput = true;
                showcasePolymophism();
            }
            else {
                System.out.println(SIMULATE_WHAT);
            }
            
        }
            
    }
        
    /**
     * This method is to showcase the difference between Dynamic 
     * and Static Types, and to show how polymorphism works.
     * 
     * First it will print out the String returned by the Static method 
     * infoAboutMe(). Due to its Static nature, it will not be Overriden
     * and only the Static Type of the object matters.
     * 
     * Next it will print out the String returned the "normal" non-static
     * method whatFood().
     * 
     * Even thought the Static Type is the same we will here see that it's
     * the dynamic type that matters. This method call would not have been
     * possible if the Static Type (the type of the superclass) didnt
     * have the whatFood() method.
     * 
     */    
    private void showcasePolymophism()
    {
        ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

        enemyList.add(enemyFactory.makeEnemy(DWARF_BANDIT, CRUDE_ITEMS, loc));
        enemyList.add(enemyFactory.makeEnemy(ELF_BANDIT, CRUDE_ITEMS, loc));
        enemyList.add(enemyFactory.makeEnemy(HUMAN_BANDIT, CRUDE_ITEMS, loc));
        
        for (Enemy theEnemy : enemyList) {
            if (theEnemy instanceof HumanBandit) {
                System.out.println(theEnemy.infoAboutMe() + "\n" + 
                                   ((HumanBandit)theEnemy).infoAboutMe());
            }
        
            else if (theEnemy instanceof ElfBandit) {
                System.out.println(theEnemy.infoAboutMe() + "\n" + 
                                   ((ElfBandit)theEnemy).infoAboutMe());
            }
        
            else {
                System.out.println(theEnemy.infoAboutMe() + "\n" + 
                                   ((DwarfBandit)theEnemy).infoAboutMe());    
            } 
            System.out.println(theEnemy.whatFood() + "\n");
        }
    }
    
    /**
     * This method shows how the enemyfactory package is used by outside
     * packages.
     * 
     * The EnemyFactory needs to know what type of enemy, what items the enemy
     * should equip, and which Location the enemy should be placed.
     * 
     * Type of enemy and location needs to be valid, if the enemy gets an 
     * invalid itemSet he will simpy not have any equiped items.
     */
    private void simulateFactory()
    {
        Enemy theEnemy = null;
        
        Scanner userInput = new Scanner(System.in);
                
        System.out.println(WHAT_ENEMY_TYPE + "\"" + HUMAN_BANDIT + 
                           "\"," + " \"" + ELF_BANDIT + "\", \"" 
                           + DWARF_BANDIT + "\".");
       
        boolean validEnemy = false;
        String typeOfEnemy = "";
        while (!validEnemy) {
            typeOfEnemy = userInput.nextLine();
            if (typeOfEnemy.equals(HUMAN_BANDIT) || 
                typeOfEnemy.equals(ELF_BANDIT) || 
                typeOfEnemy.equals(DWARF_BANDIT)) {
                    
                validEnemy = true;
            }
            else System.out.println(CHOOSE + HUMAN_BANDIT + OR
                                    + ELF_BANDIT + OR + DWARF_BANDIT);
        }
        System.out.println(WHICH_ITEMS_PART1 + CRUDE_ITEMS + WHICH_ITEMS_PART2);
        
        String itemSet = userInput.nextLine();

        
        theEnemy = enemyFactory.makeEnemy(typeOfEnemy, itemSet, loc);
            
        // prints out the enemies character sheet.
        // this method will not get called during normal enemy creation.
        theEnemy.printCharacterSheet();
        System.out.println("");
        
                   
    }
    
    /**
     * This method initiate the factory simulator.
     * 
     * @param args for command line purposes, not really needed here...
     */
    public static void main(String[] args)
    {
        EnemyFactorySimulator sim = new EnemyFactorySimulator();
    }

}