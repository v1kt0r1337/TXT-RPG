package game.spells;

import game.ResourceBundle;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EffectBankTest.
 *
 * @author  Viktor Setervang
 * @version 11.05.2015
 */
public class EffectBankTest implements ResourceBundle
{
    EffectBank effectBank;
    Effect effect1;
    
    /**
     * Default constructor for test class EffectBankTest
     */
    public EffectBankTest()
    {
        effectBank = new EffectBank();
        effect1 = new Effect(EFFECT_INCREASE_MAXWEIGHT_NAME,
                             EFFECT_INCREASE_MAXWEIGHT_EFFECTS);
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
     * The main purpose of the EffectBank is to be a collection
     * of the RPGs effects. This method tests that the getEffect 
     * method of the EffectBank works as intended.
     */
    @Test
    public void testGetEffect()
    {
        assertNotNull(effectBank.getItem("increaseMaxWeight"));
        assertNotSame(effect1, effectBank.getItem("increaseMaxWeight"));
        assertEquals(effect1, effectBank.getItem("increaseMaxWeight"));
    }
}



