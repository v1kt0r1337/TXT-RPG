package game.spells;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EffectTest.
 *
 * @author  Viktor Setervang
 * @version 11.04.2015
 */
public class EffectTest
{
    /**
     * Default constructor for test class EffectTest
     */
    public EffectTest()
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
     * Checks that the name given in the constructor is the name
     * the effect actually gets.
     */
    @Test
    public void testInitialEffectName()
    {
        Effect effect1 = new Effect("increaseMaxWeight", "maxWeight");
        
        assertEquals("increaseMaxWeight", effect1.getEffectName());
    }
    
    /**
     * Checks that the changeVariable given in the constructor is the name
     * the effect actually gets.
     */
    @Test
    public void testIntialChangeVariable()
    {
        Effect effect1 = new Effect("increaseMaxWeight", "maxWeight");
        assertEquals("maxWeight", effect1.getChangeVariable());
    }
}


