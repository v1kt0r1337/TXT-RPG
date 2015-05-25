package game.spells;

import game.ResourceBundle;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SpellTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SpellTest implements ResourceBundle
{
    Effect maxWeight;
    Spell increaseMaxWeight;
    Magic increaseMaxWeight1;
    //Item steroids;
    Effect noEffect;
    Spell noSpell;
    //Item hammer;
    Magic noMagic;

    /**
     * Default constructor for test class SpellTest
     */
    public SpellTest()
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
        
        noEffect = new Effect("noEffect", "noEffect");
        noMagic = new MagicOnUse("noSpell", MAGIC_NOMAGIC_DESC, noEffect, 0, 0,
                                 MAGIC_TARGET_SELF, -1, 0);
        noSpell = new Spell();
        noSpell.addMagic(noMagic);
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
}
