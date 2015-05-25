package game.items;

import game.ResourceBundle;
import game.spells.*;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemTest implements ResourceBundle
{
    Effect maxWeight;
    Magic increaseMaxWeight1;
    Spell increaseMaxWeight;
    Item steroids;
    
    Effect noEffect;
    Magic noMagic;
    Spell noSpell;
    Item hammer;
    
    
    /**
     * Default constructor for test class ItemTest
     */
    public ItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        maxWeight = new Effect("increaseMaxWeight", "maxWeight");
        increaseMaxWeight1 = new MagicOnUse(MAGIC_INCREASE_MAXWEIGHT1_NAME, 
                                            MAGIC_INCREASE_MAXWEIGHT1_DESC,
                                            maxWeight, 1, 1, MAGIC_TARGET_SELF, 
                                            -1, 0);
        increaseMaxWeight = new Spell();
        increaseMaxWeight.addMagic(increaseMaxWeight1);
        steroids = new ItemUseAbles(ITEM_STEROIDS_NAME, 1, ITEM_STEROIDS_DESC, 
                   ITEM_STEROIDS_ONUSE_MSG, true, increaseMaxWeight, 1);
                   
        noEffect = new Effect("noEffect", "noEffect");
        noMagic = new MagicOnUse("noSpell", MAGIC_NOMAGIC_DESC, noEffect, 
                                 0, 0, MAGIC_TARGET_SELF, -1, 0);
        noSpell = new Spell();
        noSpell.addMagic(noMagic);
        hammer = new ItemHandHeld(ITEM_HAMMER_NAME, HAND_SLOT, 51, 
                                  ITEM_HAMMER_DESC, ITEM_HAMMER_ONUSE_MSG, 
                                  noSpell, true, 1, 1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Tests that the getAllItemInfo method works as intended.
     */
    @Test
    public void testGetAllItemInfo()
    {
        assertEquals("name: Syringe%ndescription: A syringe, " + 
                     "looks like it contain some kind of experimental " +
                     "fluids%nweight: 1%n", steroids.getAllItemInfo());
    }
    
    /**
     * Tests that getItemName method provides the intended name of the item,
     * and that the item is named correctly.
     */
    @Test
    public void testGetItemName()
    {
        assertEquals("Syringe", steroids.getItemName());
    }
    
    /**
     * Tests the getItemWeight method
     */
    @Test
    public void testGetItemWeight()
    {
        assertEquals(1, steroids.getItemWeight());
    }
    
    /**
     * Checks that the isConsumAble() method is working as intended.
     */
    @Test
    public void testIsConsumAble()
    {
        assertEquals(true, ((ItemUseAbles)steroids).isConsumAble());
    }
    
    /**
     * Tests that the getItemInfo provides the intended info.
     */
    @Test
    public void testGetItemInfo()
    {  
        assertEquals("name: Syringe%nweight: 1%n", steroids.getItemInfo());
    }
    
    /**
     * Test that the getItemDescription method provides the
     * items description
     */
    @Test
    public void testGetItemDescription()
    {
        assertEquals("A syringe, looks like it contain some kind of " +
                     "experimental fluids", steroids.getItemDescription());
    }

    /**
     * Tests the setItemWeight and getItemWeight method. 
     */
    @Test
    public void testSetGetItemWeight()
    {
        assertNotNull(hammer.getItemWeight());
        hammer.setItemWeight(1);
        assertEquals(1, hammer.getItemWeight());
    }
}


