package game.enemyfactory;

import game.world.*;
import game.Character;

import static org.hamcrest.CoreMatchers.instanceOf;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DwarfBanditTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DwarfBanditTest
{
    /**
     * Default constructor for test class DwarfBanditTest
     */
    public DwarfBanditTest()
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
     *  Checks that the object created is indeed an instance of
     *  DwarfBandit and its super classes.
     */
    @Test
    public void isDwarfBandit()
    {
        game.enemyfactory.DwarfBandit dwarfBan1 = new game.enemyfactory
                                                      .DwarfBandit();
        assertNotNull(dwarfBan1);
        assertThat(dwarfBan1, instanceOf(DwarfBandit.class));
        assertThat(dwarfBan1, instanceOf(Enemy.class));
        assertThat(dwarfBan1, instanceOf(Character.class));
    }
}
