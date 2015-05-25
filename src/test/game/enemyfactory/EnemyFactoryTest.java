package game.enemyfactory;


import game.ResourceBundle;
import game.world.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EnemyFactoryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EnemyFactoryTest implements ResourceBundle
{
    private World world;
    private Location loc;

    private EnemyFactory enemyFactory;
    private game.enemyfactory.Enemy humanBan1;
    private game.enemyfactory.Enemy dwarfBan1;
    private game.enemyfactory.Enemy elfBan1;

    /**
     * Default constructor for test class EnemyFactoryTest
     */
    public EnemyFactoryTest()
    {
        world = new World();
        loc = world.getLocation(STARTLOC_NAME);
        enemyFactory = new EnemyFactory();
        humanBan1 = enemyFactory.makeEnemy(HUMAN_BANDIT, CRUDE_ITEMS, loc);
        dwarfBan1 = enemyFactory.makeEnemy(DWARF_BANDIT, CRUDE_ITEMS, loc);
        elfBan1 = enemyFactory.makeEnemy(ELF_BANDIT, "noItems", loc);
    }

    /**
     * Thats that the humanBan1 is indeed an instance of HumanBandit.
     */
    @Test
    public void testIfHumanBandit()
    {
        assertThat(humanBan1, instanceOf(HumanBandit.class));
    }

    /**
     * Thats that the elfBan1 is indeed an instance of ElfBandit.
     */
    @Test
    public void testIfElfBandit()
    {
        assertThat(elfBan1, instanceOf(ElfBandit.class));
    }

    /**
     * Thats that the dwarfBan1 is indeed an instance of DwarfBandit.
     */
    @Test
    public void testIfDwarfBandit()
    {
        assertThat(dwarfBan1, instanceOf(DwarfBandit.class));
    }

    /**
     * This method first tests that the bandit's inventory is empty.
     * Then it checks that the bandit has 7 items, if the inventory is empty,
     * but the bandit still got 7 items, then it meens that they items are 
     * equiped.
     */
    @Test
    public void checkThatHumanBanditEquipedItems()
    {
        assertEquals(0, humanBan1.getAmountOfInventoryItems());
        assertEquals(7, humanBan1.getAmountOfItems());
    }
    

    /**
     * This method first tests that the bandit's inventory is empty.
     * Then it checks that the bandit has 7 items, if the inventory is empty,
     * but the bandit still got 7 items, then it meens that the items are 
     * equiped.
     * 
     */
    @Test
    public void checkThatDwarfBanditEquipedItems()
    {
        assertEquals(0, dwarfBan1.getAmountOfInventoryItems());
        assertEquals(7, dwarfBan1.getAmountOfItems());
    }  
    
    /**
     * The object of ElfBandit did not get any items.
     * So here we check that the bandit doesn't have items.
     */
    @Test
    public void checkThatElfBanditEquipedItems()
    {
        assertEquals(0, elfBan1.getAmountOfItems());
    }
    
    /**
     * This method tests that the enemy got properly initialized
     * and is not null.
     * 
     * It also checks that an enemy gets made even thought he is not
     * given items.
     * 
     */
    @Test
    public void notNull()
    {
        assertNotNull(enemyFactory.makeEnemy("humanBandit", "crudeItems", loc));
        assertNotNull(enemyFactory.makeEnemy("humanBandit", "nada", loc));
    }

    /**
     * This method tests that the location gives to the bandits during
     * creation, is indeed the location that the bandits has stored as their
     * location.
     */
    @Test
    public void testGetLocation()
    {
        assertSame(loc, humanBan1.getLocation());
        assertSame(loc, elfBan1.getLocation());
        assertSame(loc, dwarfBan1.getLocation());
    }
}






